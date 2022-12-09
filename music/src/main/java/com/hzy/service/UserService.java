package com.hzy.service;

import com.hzy.pojo.User;

public interface UserService {
    boolean userIsCunZai (String usernaem);

    boolean login(User user);

    boolean addUser(User user);

    int getId(String username);


}
