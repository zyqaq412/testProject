package com.studentTest.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modify")
public class Modify extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminU = req.getParameter("id");
        String studentId = req.getParameter("v");

        req.setAttribute("adminU",adminU);
        req.setAttribute("studentId",studentId);
        req.getRequestDispatcher("modifyPage.jsp").forward(req,resp);


    }
}
