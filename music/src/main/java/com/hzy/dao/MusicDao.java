package com.hzy.dao;

import com.hzy.pojo.Music;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MusicDao {

    /**
     * 上传音乐
     * @param music
     * @return
     */
    @Insert("insert into music values(null,#{title},#{singer},#{time},#{url},#{userid})")
    int insert(Music music);

    /**
     * 根据歌曲名称找音乐
     * @param title
     * @return
     */
    @Select("select * from music where title like #{title}")
    List<Music> selectByTitle(String title);

    /**
     * 查询所有音乐
     * @return
     */
    @Select("select * from music")
    List<Music> selectAll();

    /**
     * 根据id查音乐
     * @param id
     * @return
     */
    @Select("select * from music where id=#{id}")
    Music selectById(Integer id);

    /**
     * 根据id删除音乐
     * @param id
     * @return
     */
    @Delete("delete from music where id = #{id}")
    int deleteById(Integer id);
}
