package com.hzy.service.impl;

import com.hzy.dao.MusicDao;
import com.hzy.dao.UserDao;
import com.hzy.pojo.User;
import com.hzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @title: UserServiceImpl
 * @Author zxwyhzy
 * @Date: 2022/12/9 22:38
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public boolean userIsCunZai(String usernaem) {
        User user = userDao.selectByName(usernaem);
        if (null != user){
            return true;
        }
        return false;
    }

    @Override
    public boolean login(User user) {
        User user1 = userDao.selectByNameAndPassword(user);
        if (null != user1){
            return true;
        }
        return false;
    }

    @Override
    public boolean addUser(User user) {
        int i = userDao.addByUser(user);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public int getId(String username) {
        return userDao.selectByNamerId(username);
    }


}
