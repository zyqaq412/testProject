package com.hzy.pojo;

import java.util.List;

/**
 * @title: PageBean
 * @Author zxwyhzy
 * @Date: 2022/11/17 15:42
 * @Version 1.0
 */
public class PageBean<T> {
    // 总记录数
    private int totalCount;
    // 当前页数据
    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
