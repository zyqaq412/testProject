package com.hzy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @title: AppConfig
 * @Author zxwyhzy
 * @Date: 2022/12/10 12:44
 * @Version 1.0
 */
@Configuration//告诉spring这是一个配置类
public class AppConfig implements WebMvcConfigurer {
    @Autowired
    private ProjectInterceptor projectInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/**")
                //排除所有的JS
                .excludePathPatterns("/js/**.js")
                //排除img下所有的元素
                .excludePathPatterns("/img/**")
                .excludePathPatterns("/css/**.css")
                .excludePathPatterns("/fronts/**")
                .excludePathPatterns("/player/**")
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/reg.html")
                //排除登录注册接口
                .excludePathPatterns("/user/**")
                .excludePathPatterns("/user");
    }
}
