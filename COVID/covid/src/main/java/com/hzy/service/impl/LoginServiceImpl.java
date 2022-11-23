package com.hzy.service.impl;

import com.hzy.dao.StudentDao;
import com.hzy.dao.TeacherDao;
import com.hzy.pojo.Student;
import com.hzy.pojo.Teacher;
import com.hzy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @title: LoginServiceImpl
 * @Author zxwyhzy
 * @Date: 2022/11/22 12:24
 * @Version 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;

    @Override
    public Student login(Student student) {
        return studentDao.login(student);
    }

    @Override
    public Teacher login(Teacher teacher) {
        return teacherDao.login(teacher);
    }
}
