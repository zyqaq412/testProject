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

@WebServlet("/del")
public class Delete extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("v");
        FileService fs = new FileServiceImpl();

        fs.delPersonFile(studentId);

        String id = req.getParameter("id");
        FileService fs2 = new FileServiceImpl();
        User adminU = fs2.getAdmin(id);
        FileService f = new FileServiceImpl();
        ArrayList<User> arr= f.getAllStudent();
        req.setAttribute("arr",arr);
        req.setAttribute("user",adminU);
        req.getRequestDispatcher("adminPage.jsp").forward(req,resp);
    }
}
