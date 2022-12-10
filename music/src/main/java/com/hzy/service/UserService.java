package com.hzy.service;

import com.hzy.pojo.User;

public interface UserService {

    /**
     * 查看用户是否存在
     * @param usernaem
     * @return
     */
    boolean userIsCunZai (String usernaem);

    /**
     * 登录
     * @param user
     * @return
     */
    boolean login(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 根据用户名获取id
     *
     * @param username
     * @return id
     */
    int getId(String username);


}
