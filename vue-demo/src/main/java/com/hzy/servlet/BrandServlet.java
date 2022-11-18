package com.hzy.servlet;

import com.alibaba.fastjson.JSON;
import com.hzy.pojo.Brand;
import com.hzy.pojo.PageBean;
import com.hzy.service.BrandService;
import com.hzy.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @title: BrandServlet
 * @Author zxwyhzy
 * @Date: 2022/11/17 15:14
 * @Version 1.0
 */
@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    BrandService bs = new BrandServiceImpl();

    /**
     * 修改数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void modifyById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        BufferedReader reader = request.getReader();
        String jsonString = reader.readLine();

        Brand brand = JSON.parseObject(jsonString, Brand.class);
        bs.modifyById(brand);

        response.getWriter().write("success");

    }

    /**
     * 删除
     */
    public void deleteById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String id = request.getParameter("id");
        bs.deleteById(Integer.parseInt(id));
        response.getWriter().write("success");

    }
    /**
     * 批量删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String jsonString = reader.readLine();//json [1,2,3]
        //将json转换成 int数组
        int[] ids = JSON.parseObject(jsonString, int[].class);
        bs.deleteByIds(ids);
        response.getWriter().write("success");
    }


    /**
     * 添加数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串
        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        //2. 调用service添加
        bs.addBrand(brand);
        //3. 响应成功的标识
        response.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int sizePage = Integer.parseInt(request.getParameter("sizePage"));
        /*int currentPage = 1;
        int sizePage = 5;*/
        String jsonString1 = request.getReader().readLine();
        Brand brand = JSON.parseObject(jsonString1, Brand.class);
        System.out.println(brand);

        PageBean<Brand> pageBean = bs.selectByPage(currentPage,sizePage,brand);


        String jsonString = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
