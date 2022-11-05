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

@WebServlet("/addUp")
public class addUp extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String admId = req.getParameter("adminId");

        int a1 = Integer.parseInt(req.getParameter("a1"));
        String a2 = req.getParameter("a2");
        String a3 = req.getParameter("a3");
        String a4 = req.getParameter("a4");
        String a5 = req.getParameter("a5");
        int a6 = Integer.parseInt(req.getParameter("a6"));

        FileService fs = new FileServiceImpl();
        fs.addUp(a1,a2,a3,a4,a5,a6);

        User user = fs.getAdmin(admId);
        ArrayList<User> arr = fs.getAllStudent();
        req.setAttribute("user",user);
        req.setAttribute("arr",arr);

        req.getRequestDispatcher("adminPage.jsp").forward(req,resp);
    }
}
