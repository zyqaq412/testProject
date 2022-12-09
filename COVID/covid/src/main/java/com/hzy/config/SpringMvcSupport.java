package com.hzy.config;

import com.hzy.controller.interceptor.ProjectInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


/**
 * @title: SpringMvcSupport
 * @Author zxwyhzy
 * @Date: 2022/11/21 11:36
 * @Version 1.0
 */
@Configuration
public class SpringMvcSupport implements WebMvcConfigurer {
    @Autowired
    private ProjectInterceptor projectInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/imgs/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/element-ui/**/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/pages/login.html")
                .excludePathPatterns("/login")
                .excludePathPatterns("/index.html");
    }

}
