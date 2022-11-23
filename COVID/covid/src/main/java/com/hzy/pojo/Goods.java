package com.hzy.pojo;

/**
 * @title: Goods
 * @Author zxwyhzy
 * @Date: 2022/11/22 15:25
 * @Version 1.0
 */
public class Goods {
    private Integer wid;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    private String wname;
    private Integer wcount;
    private String time;

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public Integer getWcount() {
        return wcount;
    }

    public void setWcount(Integer wcount) {
        this.wcount = wcount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
