package com.hzy.service;

import com.hzy.pojo.Music;

import java.util.List;

public interface MusicService {
    boolean addMusic(Music music);
    List<Music> selectByTitle(String title);
    List<Music> selectAll();

    Music selectById(Integer id);

    boolean deleteById(Integer id);

}
