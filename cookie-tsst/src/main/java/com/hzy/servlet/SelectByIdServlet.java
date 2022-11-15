package com.hzy.servlet;

import com.hzy.pojo.Brand;
import com.hzy.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println(1);
            int id = Integer.parseInt(request.getParameter("id"));
            Brand brand = new BrandService().SelectById(id);
            request.setAttribute("brand",brand);
            request.getRequestDispatcher("modify.jsp").forward(request,response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request, response);
        }
    }


