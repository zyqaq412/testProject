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

@WebServlet("/updateUp")
public class updateUp extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuId = req.getParameter("stuId");

        String a1 = req.getParameter("a1");
        String a2 = req.getParameter("a2");
        String a3 = req.getParameter("a3");
        String a4 = req.getParameter("a4");

        FileService fs = new FileServiceImpl();
        fs.update(stuId,a1,a2,a3,a4);

        User user = fs.getAdmin(stuId);
        ArrayList<User> arr = fs.getAllStudent();
        req.setAttribute("user",user);
        req.setAttribute("arr",arr);

        req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
    }
}
