package com.hzy.servlet;

import com.hzy.mapper.UserMapper;
import com.hzy.pojo.User;
import com.hzy.service.UserService;
import com.hzy.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LonginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");//设置响应字符编码
        //获取复选框数据
        String remember =request.getParameter("remember");

        //接收用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        User loginUser = new UserService().login(user);

        //判断用户是否勾选记住我
        if (loginUser != null){
            if ("1".equals(remember)){
                //创建cookie
                Cookie c_username = new Cookie("username",username) ;
                Cookie c_password = new Cookie("password",password) ;
                //设置cookie存活时间
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);
                //发送cookie
                response.addCookie(c_username);
                response.addCookie(c_password);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            //登录成功
            request.setAttribute("user",user);
            request.getRequestDispatcher("/SelectAllServlet").forward(request,response);
        }else {
            //登录失败
            request.setAttribute("login_msg","用户名或密码错误");
            //response.sendRedirect("/cookie-tsst");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
