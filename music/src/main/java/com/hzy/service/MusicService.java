package com.hzy.service;

import com.hzy.pojo.Music;

import java.util.List;

public interface MusicService {
    /**
     * 上传音乐
     * @param music
     * @return
     */
    boolean addMusic(Music music);

    /**
     * 根据名字模糊查询
     * @param title
     * @return
     */
    List<Music> selectByTitle(String title);

    /**
     * 查询所有歌曲
     * @return
     */
    List<Music> selectAll();

    /**
     * 根据id查找
     * @param id
     * @return
     */
    Music selectById(Integer id);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

}
