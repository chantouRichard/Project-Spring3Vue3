<script setup>
import { ref } from "vue";
import { useUserInfoStore } from "@/stores/userInfo.js";
const userInfoStore = useUserInfoStore();
const userInfo = ref({ ...userInfoStore.info });
const passwordModel = ref({
  old_pwd: "",
  new_pwd: "",
  re_pwd: "",
});
const rules = {
  old_pwd: [
    { required: true, message: "请输入用户名", trigger: "blur" },
    { min: 5, max: 16, message: "长度在 5 到 16 个字符", trigger: "blur" },
  ],
  new_pwd: [
    { required: true, message: "请输入新密码", trigger: "blur" },
    { min: 5, max: 16, message: "长度在 5 到 16 个字符", trigger: "blur" },
  ],
  re_pwd: [
    { required: true, message: "请输入确认密码", trigger: "blur" },
    { min: 5, max: 16, message: "长度在 5 到 16 个字符", trigger: "blur" },
  ],
};
import { ElMessage } from "element-plus";
//修改密码
import { userPasswordUpdateService } from "@/api/user.js";
import { useRouter } from "vue-router";
const router = useRouter();
const updatePassword = async () => {
  //调用接口
  let result = await userPasswordUpdateService(passwordModel.value);

  ElMessage.success(result.msg ? result.msg : "修改成功,请重新登录");
  //修改pinia中的数据
  userInfoStore.setUserInfo({ ...result.data });
  //重新登录
  //1、清空pinia中的用户信息和token
  tokenStore.removeToken();
  userInfoStore.removeInfo();
  //2、跳转到登录页面
  router.push("/login");
};
</script>

<template>
  <el-card class="page-container">
    <template #header>
      <div class="header">
        <span>重置密码</span>
      </div>
    </template>
    <el-row>
      <el-col :span="12">
        <el-form
          :model="passwordModel"
          :rules="rules"
          label-width="100px"
          size="large"
        >
          <el-form-item label="原密码" prop="old_pwd">
            <el-input
              :prefix-icon="Lock"
              type="password"
              placeholder="请输入原密码"
              v-model="passwordModel.old_pwd"
            ></el-input>
          </el-form-item>
          <el-form-item label="新密码" prop="new_pwd">
            <el-input
              :prefix-icon="Lock"
              type="password"
              placeholder="请输入新密码"
              v-model="passwordModel.new_pwd"
            ></el-input>
          </el-form-item>
          <el-form-item label="确认新密码" prop="re_pwd">
            <el-input
              :prefix-icon="Lock"
              type="password"
              placeholder="请再次输入密码"
              v-model="passwordModel.re_pwd"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="updatePassword"
              >提交修改</el-button
            >
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </el-card>
</template>
