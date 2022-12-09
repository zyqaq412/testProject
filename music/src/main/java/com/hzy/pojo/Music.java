package com.hzy.pojo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lenovo
 * Date: 2022-07-27
 * Time: 22:48
 */
@Data//自动生成方法
public class Music {
    private Integer id;
    private String title;
    private String singer;
    private String time;
    private String url;
    private Integer userid;
}
