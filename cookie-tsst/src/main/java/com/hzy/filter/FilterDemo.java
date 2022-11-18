package com.hzy.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/*
 * 登录验证过滤器
 *
 * */
@WebFilter("/*")
public class FilterDemo implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        //1.判断session中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        //2.判断user是否为空
        if (user !=null){
            //用户登录过了
            chain.doFilter(request,response);
        }else {
            //用户没有登录 存储登录信息，跳转到登录界面
            req.setAttribute("login_msg","你未登录");
            req.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        chain.doFilter(request, response);
    }
    public void init(FilterConfig config) throws ServletException {
    }
    public void destroy() {
    }
}
