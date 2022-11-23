package com.hzy.pojo;

/**
 * @title: ResDao
 * @Author zxwyhzy
 * @Date: 2022/11/22 16:46
 * @Version 1.0
 */
public class Res {
    private Integer sid;
    private Integer wid;
    private Integer count;
    private Integer bid;

    private String wname;

    private Integer status;

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
