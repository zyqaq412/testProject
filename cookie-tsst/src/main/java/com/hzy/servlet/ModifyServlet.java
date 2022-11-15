package com.hzy.servlet;

import com.hzy.pojo.Brand;
import com.hzy.service.BrandService;
import com.hzy.util.UTIL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");//设置响应字符编码
        String contextPath = request.getContextPath();
        int id = Integer.parseInt(request.getParameter("id"));
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        int ordered = Integer.parseInt(request.getParameter("ordered"));
        String description = request.getParameter("description");
        int status = Integer.parseInt(request.getParameter("status"));
        Brand brand = new Brand();
        brand.setId(id);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setStatus(status);
        new BrandService().modify(brand);
        response.sendRedirect(contextPath+"/SelectAllServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
