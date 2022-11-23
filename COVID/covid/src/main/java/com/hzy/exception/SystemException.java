package com.hzy.exception;

/**
 * @title: SystemException
 * @Author zxwyhzy
 * @Date: 2022/11/21 11:09
 * @Version 1.0
 */
public class SystemException extends RuntimeException{
    private Integer code;

    public SystemException( Integer code,String message) {
        super(message);
        this.code = code;
    }

    public SystemException(Integer code ,String message, Throwable cause) {
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
