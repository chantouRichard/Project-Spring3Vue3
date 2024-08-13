import { createRouter,createWebHistory } from "vue-router";

//导入组件
import LoginVue from '@/views/Login.vue'
import LayoutVue from '@/views/Layout.vue'

import ArticleCategory from "@/views/article/ArticleCategory.vue";
import ArticleManageVue from "@/views/article/ArticleManage.vue";
import UserAvatarVue from "@/views/user/UserAvatar.vue";
import UserInfoVue from "@/views/user/UserInfo.vue";
import UserResetPasswordVue from "@/views/user/UserResetPassword.vue";

//定义路由关系
const routes = [
    {path: '/login', component: LoginVue},
    {path: '/', component: LayoutVue,redirect:'/article/manage',children:[
        {path: '/article/category', component: ArticleCategory},
        {path: '/article/manage', component: ArticleManageVue},
        {path: '/user/avatar', component: UserAvatarVue},
        {path: '/user/info', component: UserInfoVue},
        {path: '/user/resetpassword', component: UserResetPasswordVue}
    ]}
]

//创建路由对象
const router = createRouter({
    history:createWebHistory(),
    routes:routes
})

//导出路由对象
export default router;