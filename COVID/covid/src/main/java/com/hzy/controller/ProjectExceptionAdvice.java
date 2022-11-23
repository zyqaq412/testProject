package com.hzy.controller;

import com.hzy.exception.BusinessException;
import com.hzy.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @title: ProjectExceptionAdvice
 * @Author zxwyhzy
 * @Date: 2022/11/21 10:53
 * @Version 1.0
 */
@RestControllerAdvice//声明为异常处理类
//@ControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)//声明处理什么异常
    public Result doSystemException(SystemException ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员

        return new Result(ex.getCode(),null,ex.getMessage());
    }
    @ExceptionHandler(BusinessException.class)//声明处理什么异常
    public Result doBusinessException(BusinessException ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    @ExceptionHandler(Exception.class)//声明处理什么异常
    public Result doException(Exception ex){

        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统繁忙！请稍后再试");
    }
}
