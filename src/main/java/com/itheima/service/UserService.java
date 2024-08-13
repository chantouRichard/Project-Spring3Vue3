package com.itheima.service;

import com.itheima.pojo.User;

public interface UserService {
    User findByUserName(String username);

    void register(String username, String password);

    void update(User user);

    void updateAvatar(String avatarUrl);

    void updatePwd(String newPwd);
    //根据用户名查询用户
}
