package com.studentTest.servlet;

import com.studentTest.bean.User;
import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/goMainPage")
public class GoMainPage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminU = req.getParameter("v");
        FileService fs = new FileServiceImpl();
        User admin = fs.getAdmin(adminU);
        ArrayList<User> arr =fs.getAllStudent();
        req.setAttribute("arr",arr);
        req.setAttribute("user",admin);
        if (admin.getRole()==0){req.getRequestDispatcher("adminPage.jsp").forward(req,resp);}
        else{req.getRequestDispatcher("mainPage.jsp").forward(req,resp);}
    }
}
