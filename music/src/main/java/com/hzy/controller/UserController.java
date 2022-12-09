package com.hzy.controller;

import com.hzy.pojo.User;
import com.hzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @title: UserController
 * @Author zxwyhzy
 * @Date: 2022/12/9 22:29
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("login")
    public Result login(@RequestBody User user, HttpServletRequest request){
        //System.out.println(user);
        boolean b = userService.userIsCunZai(user.getUsername());
        if (b){
            boolean login = userService.login(user);
            if (login){
                user.setId(userService.getId(user.getUsername()));
                request.getSession().setAttribute(Code.SESSION_OK,user);
                return new Result(Code.LOGIN_OK,user,"登录成功");
            }else {
                return new Result(Code.LOGIN_ERR,null,"登录失败，用户名或密码错误！");
            }

        }else {
            return new Result(Code.LOGIN_ERR,null,"登录失败，用户不存在！");
        }
    }
    @PostMapping
    public Result register (@RequestBody User user){
        System.out.println(user);
        boolean c = userService.userIsCunZai(user.getUsername());
        if (!c){
            boolean b = userService.addUser(user);
            if (b){
                return new Result(Code.REGISTER_OK,null,"注册成功");
            }else {
                return new Result(Code.REGISTER_ERR,null,"注册失败");
            }
        }else {
            return new Result(Code.REGISTER_ERR,null,"注册失败，用户以存在");
        }

    }
}
