package com.hzy.dao;

import com.hzy.pojo.Music;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoveMusicDao {

    /**
     * 收藏音乐
     * @param musicId
     * @param userId
     * @return
     */
    @Insert("insert into lovemusic values (null,#{userId},#{musicId})")
    int insert(Integer musicId,Integer userId);

    /**
     * 查询当前用户收藏的音乐
     * @param userId
     * @return
     */
    //@Select("select * from lovemusic where user_id = #{userId}")
    @Select("select m.* from lovemusic lm,music m where m.id = lm.music_id and lm.user_id=#{userInd}")
    List<Music> selectLoveMusicByUserId(Integer userId);

    /**
     * 查询当前音乐是否已经收藏
     * @param userId
     * @param musicId
     * @return
     */
    @Select("select * from lovemusic where user_id=#{userId} and music_id=#{musicId}")
    Music selectByUserIdAndMusicId(Integer userId,Integer musicId);

    /**
     * 取消收藏
     * @param userId
     * @param musicId
     * @return
     */
    @Delete("delete from lovemusic where user_id=#{userId} and music_id=#{musicId}")
    int deleteByMusicIdAndUserId(Integer userId,Integer musicId);

    /**
     * 删除前查询是否存在
     * @param userId
     * @param musicId
     * @return
     */
    @Select("select * from lovemusic where user_id=#{userId} and music_id=#{musicId}")
    Music selectByMusicIdAndUserId(Integer userId,Integer musicId);
}
