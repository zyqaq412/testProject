package com.hzy.controller;

import com.hzy.pojo.Res;
import com.hzy.pojo.Student;
import com.hzy.pojo.Teacher;
import com.hzy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @title: AdminController
 * @Author zxwyhzy
 * @Date: 2022/11/22 20:44
 * @Version 1.0
 */
@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping
    public Result getAllStudent(HttpServletRequest request){
        Teacher teacher = (Teacher) request.getSession().getAttribute(Code.SESSION_OK);
        List<Student> list = adminService.getAllStudent(teacher.getTid());
        return new Result(Code.GET_OK,list,"查询成功");

    }
    @GetMapping("/res")
    public Result getAllRes(HttpServletRequest request){
        Teacher teacher = (Teacher) request.getSession().getAttribute(Code.SESSION_OK);
        List<Res> list = adminService.getAllRes(teacher.getBid());
        return new Result(Code.GET_OK,list,"查询成功");

    }
}
