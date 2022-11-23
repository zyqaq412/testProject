package com.hzy.controller;

/**
 * @title: Result
 * @Author zxwyhzy
 * @Date: 2022/11/21 10:18
 * @Version 1.0
 */

/**
 * 传给前端的数据类
 */
public class Result {
    private Object data; //封装数据
    private Integer code;//状态码
    private String msg;//消息



    public Result(Integer code,Object data,  String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code,Object data) {
        this.data = data;
        this.code = code;
    }

    public Result(){
    }

    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
