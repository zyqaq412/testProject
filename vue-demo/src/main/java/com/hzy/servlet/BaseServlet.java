package com.hzy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @title: BaseServlet
 * @Author zxwyhzy
 * @Date: 2022/11/17 15:10
 * @Version 1.0
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //StringBuffer url = req.getRequestURL();//http://localhost:8080/vue-demo/brand/*
        //*是 访问路径 也是 方法名
        //1. 获取请求路径
        String uri = req.getRequestURI();///vue-demo/brand/*
        //2. 获取最后一段路径，方法名
        int index = uri.lastIndexOf('/');//从字符串后面开始查找 第一个 / 的下标
        String methodName = uri.substring(index + 1); //  左边闭区间 所以加1
        System.out.println(methodName);

        //3. 执行方法
        //3.1 获取BrandServlet /UserServlet 字节码对象 Class
        //System.out.println(this);
        Class<? extends BaseServlet> cls = this.getClass();
        try {
            Method method = cls.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
