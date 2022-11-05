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

@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查看成绩
        String studentId = req.getParameter("v");
        FileService fs = new FileServiceImpl();
        //System.out.println("1111");
        ArrayList studentUser = fs.getPersonFile(studentId);
        /*for (int i = 0;i<studentUser.size();i++){
            System.out.println(studentUser.get(i));
        }*/

        req.setAttribute("arr",studentUser);
        req.getRequestDispatcher("scorePage.jsp").forward(req,resp);



        String id = req.getParameter("id");
    }
}
