package com.hzy.servlet;

import com.hzy.mapper.UserMapper;
import com.hzy.pojo.User;
import com.hzy.service.UserService;
import com.hzy.util.SqlSessionFactoryUtil;
import com.hzy.util.UTIL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = UTIL.luanMa(request.getParameter("username"));
        String password = UTIL.luanMa(request.getParameter("password"));

        //获取用户输入验证码
        String checkCode = request.getParameter("checkCode");
        //获取程序生成验证码
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        if (!checkCodeGen.equals(checkCode)){
            response.sendRedirect("/cookie-tsst/register.jsp");
        }else {
            UserService userService = new UserService();
            User user = userService.selectByUsername(username);
            if (user == null){
                user = new User();
                user.setUsername(username);
                user.setPassword(password);
                userService.add(user);
                response.sendRedirect("/cookie-tsst");
            }else {
                response.sendRedirect("/cookie-tsst/register.jsp");
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
