package com.studentTest.service;

import com.studentTest.bean.User;
import com.studentTest.dao.LoginDaoImpl;
import com.studentTest.dao.loginDao;
import com.sun.xml.internal.ws.dump.LoggingDumpTube;

public class loginServiceImpl implements loginService{

    @Override
    public User loginService(User u) {
        loginDao ld = new LoginDaoImpl();
        return ld.logindao(u);
    }
}
