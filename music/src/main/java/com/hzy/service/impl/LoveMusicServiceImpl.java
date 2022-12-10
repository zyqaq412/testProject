package com.hzy.service.impl;

import com.hzy.dao.LoveMusicDao;
import com.hzy.pojo.Music;
import com.hzy.service.LoveMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: LoveMusicServiceImpl
 * @Author zxwyhzy
 * @Date: 2022/12/10 14:28
 * @Version 1.0
 */
@Service
public class LoveMusicServiceImpl implements LoveMusicService {
    @Autowired
    LoveMusicDao loveMusicDao;
    @Override
    public boolean addLoveMusic(Integer musicId, Integer userId) {
        return loveMusicDao.insert(musicId,userId)>0?true:false;
    }

    @Override
    public List<Music> selectAllLoveMusic(Integer userId) {
        return loveMusicDao.selectLoveMusicByUserId(userId);
    }

    @Override
    public boolean selectByUserIdAndMusicId(Integer userId, Integer musicId) {
        Music music = loveMusicDao.selectByUserIdAndMusicId(userId, musicId);
        if (null != music){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean deleteByMusicIdAndUserId(Integer userId, Integer musicId) {
        return loveMusicDao.deleteByMusicIdAndUserId(userId,musicId) >0 ? true:false;
    }

    @Override
    public boolean selectByMusicIdAndUserId(Integer userId, Integer musicId) {
        Music music = loveMusicDao.selectByMusicIdAndUserId(userId, musicId);
        if (null!=music){
            return true;
        }
        return false;
    }
}
