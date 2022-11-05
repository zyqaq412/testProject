package com.studentTest.servlet;
import com.studentTest.bean.User;
import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;
import com.studentTest.service.loginService;
import com.studentTest.service.loginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*这个注解就是我们取的名字为了让前端代码来访问*/
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收前端传过来的数据
        String u_id = req.getParameter("u_id");
        String u_pwd = req.getParameter("u_pwd");
        User u = new User();
        u.setU_id(Integer.valueOf(u_id));
        u.setU_pwd(u_pwd);

        //实现登录服务层的业务逻辑层
        loginService l =new loginServiceImpl();
        User user = l.loginService(u);
        //if(u.getU_id()==user.getU_id()&&u_pwd.equals(user.getU_pwd())){
        if (user != null){

            FileService fs = new FileServiceImpl();
            ArrayList<User> arr = fs.getAllStudent();
            req.setAttribute("user",user);
            req.setAttribute("arr",arr);

            if(user.getRole()==1){

                req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
            }else {
                req.getRequestDispatcher("adminPage.jsp").forward(req,resp);
            }

        }else {
            req.setAttribute("error","账户密码不一致!");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }





    }
}
