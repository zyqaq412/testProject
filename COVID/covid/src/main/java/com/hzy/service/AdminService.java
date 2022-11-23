package com.hzy.service;

import com.hzy.pojo.Res;
import com.hzy.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminService {
    List<Student> getAllStudent(Integer id);
    List<Res> getAllRes(Integer id);

}
