package com.hzy.exception;

/**
 * @title: BusinessException
 * @Author zxwyhzy
 * @Date: 2022/11/21 11:12
 * @Version 1.0
 */
public class BusinessException extends RuntimeException{
    private Integer code;

    public BusinessException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public BusinessException( Integer code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
