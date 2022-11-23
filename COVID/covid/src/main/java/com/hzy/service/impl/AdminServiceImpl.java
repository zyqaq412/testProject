package com.hzy.service.impl;

import com.hzy.dao.StudentDao;
import com.hzy.pojo.Res;
import com.hzy.pojo.Student;
import com.hzy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: AdminServiceImpl
 * @Author zxwyhzy
 * @Date: 2022/11/22 20:47
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> getAllStudent(Integer id) {

        return studentDao.getAllStudent(id);
    }

    @Override
    public List<Res> getAllRes(Integer id) {
        return studentDao.getAllRes(id);
    }


}
