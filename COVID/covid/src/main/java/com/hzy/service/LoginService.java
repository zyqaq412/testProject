package com.hzy.service;

import com.hzy.pojo.Student;
import com.hzy.pojo.Teacher;

public interface LoginService {
    Student login(Student student);
    Teacher login(Teacher teacher);
 }
