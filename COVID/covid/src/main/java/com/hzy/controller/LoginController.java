package com.hzy.controller;

import com.hzy.pojo.Student;
import com.hzy.pojo.Teacher;
import com.hzy.pojo.User;
import com.hzy.service.LoginService;
import org.apache.ibatis.javassist.compiler.ast.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @title: LoginController
 * @Author zxwyhzy
 * @Date: 2022/11/22 12:20
 * @Version 1.0
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping
    public Result login(@RequestBody User user, HttpServletRequest request){
        System.out.println(user);
        if (user.getLevel()==0){
            Student student = new Student();
            student.setSid(user.getUsername());
            student.setPassword(user.getPassword());
            Student student1 = loginService.login(student);
            if (null == student1){
               return  new Result(Code.LOGIN_ERR,null,"密码错误");
            }
            request.getSession().setAttribute(Code.SESSION_OK,student1);
            return new Result(Code.LOGIN_OK,student1,"登录成功");
        }else if(user.getLevel() <= 2){
            Teacher teacher = new Teacher();
            teacher.setTid(user.getUsername());
            teacher.setPassword(user.getPassword());
            Teacher teacher1 = loginService.login(teacher);
            if (null == teacher1){
               return new Result(Code.LOGIN_ERR,null,"密码错误");
            }
            request.getSession().setAttribute(Code.SESSION_OK,teacher1);
            return new Result(Code.LOGIN_OK,teacher1,"登录成功");
        }
        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"服务器繁忙");
    }
    @GetMapping
    public String getName(HttpServletRequest request){
        Student student = (Student)request.getSession().getAttribute(Code.SESSION_OK);
        return student.getName();
    }
}
