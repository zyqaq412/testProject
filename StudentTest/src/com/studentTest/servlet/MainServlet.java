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

@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取查询框数据
        String v = req.getParameter("v");

        FileService fs = new FileServiceImpl();
        User user = fs.getFileByNameOrId(v);
        ArrayList<User> arr = new ArrayList<>();
        arr.add(user);

        //获取登录用户id
        String id = req.getParameter("id");
        User adminU = fs.getAdmin(id);
        req.setAttribute("user",adminU);

        if (user == null){
            ArrayList<User> arr2 = fs.getAllStudent();
            req.setAttribute("arr",arr2);//将数据传到请求域
            if (adminU.getRole()==0){req.getRequestDispatcher("adminPage.jsp").forward(req,resp);}
            else{req.getRequestDispatcher("mainPage.jsp").forward(req,resp);}
        }else {
            req.setAttribute("arr",arr);
            if (adminU.getRole()==0){req.getRequestDispatcher("adminPage.jsp").forward(req,resp);}
            else{req.getRequestDispatcher("mainPage.jsp").forward(req,resp);}
        }
    }
}
