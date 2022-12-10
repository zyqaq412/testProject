package com.hzy.service;

import com.hzy.pojo.Music;

import java.util.List;

public interface LoveMusicService {

    /**
     * 收藏音乐
     * @param musicId
     * @param userId
     * @return
     */
     boolean addLoveMusic(Integer musicId, Integer userId);

    /**
     * 查询当前用户收藏的音乐
     * @param userId
     * @return
     */
    List<Music> selectAllLoveMusic(Integer userId);
    /**
     * 查询当前音乐是否已经收藏
     * @param userId
     * @param musicId
     * @return
     */
    boolean selectByUserIdAndMusicId(Integer userId,Integer musicId);

    /**
     * 取消收藏
     * @param userId
     * @param musicId
     * @return
     */
    boolean deleteByMusicIdAndUserId(Integer userId,Integer musicId);

    /**
     * 查询是否存在
     * @param userId
     * @param musicId
     * @return
     */
    boolean selectByMusicIdAndUserId(Integer userId,Integer musicId);
}
