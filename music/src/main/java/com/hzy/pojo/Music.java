package com.hzy.pojo;

import lombok.Data;

/**
 * id
 * title 歌曲名称
 * singer 歌手名称
 * time 上传时间
 * url 播放路径
 * userid 上传用户id
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
