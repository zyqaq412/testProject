package com.hzy.service.impl;

import com.hzy.dao.MusicDao;
import com.hzy.pojo.Music;
import com.hzy.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: MusicServiceImpl
 * @Author zxwyhzy
 * @Date: 2022/12/9 23:57
 * @Version 1.0
 */
@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    MusicDao musicDao;

    @Override
    public boolean addMusic(Music music) {
        int insert = musicDao.insert(music);
        if (insert>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Music> selectByTitle(String title) {
        return musicDao.selectByTitle(title);
    }

    @Override
    public List<Music> selectAll() {
        return  musicDao.selectAll();
    }

    @Override
    public Music selectById(Integer id) {
        /*Music music = musicDao.selectById(id);
        if (null!=music){
            return true;
        }*/
        return musicDao.selectById(id);
    }
    @Override
    public boolean deleteById(Integer id) {

        return musicDao.deleteById(id) >0 ? true:false;
    }
}
