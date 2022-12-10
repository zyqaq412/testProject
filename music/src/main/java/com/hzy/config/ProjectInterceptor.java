package com.hzy.config;

import com.hzy.controller.Code;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @title: ProjectInterceptor
 * @Author zxwyhzy
 * @Date: 2022/12/10 12:43
 * @Version 1.0
 */
@Component
//定义拦截器类，实现HandlerInterceptor接口
//注意当前类必须受Spring容器控制
public class ProjectInterceptor implements HandlerInterceptor {
    @Override
    //原始方法调用前执行的内容
    //返回值类型可以拦截控制的执行，true放行，false终止
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        //System.out.println(session);
        if (session != null && session.getAttribute(Code.SESSION_OK)!=null){
            return true;
        }
        return false;
    }

}
