package com.hzy.dao;

import com.hzy.pojo.Music;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MusicDao {

    @Insert("insert into music values(null,#{title},#{singer},#{time},#{url},#{userid})")
    int insert(Music music);

    @Select("select * from music where title like #{title}")
    List<Music> selectByTitle(String title);

    @Select("select * from music")
    List<Music> selectAll();

    @Select("select * from music where id=#{id}")
    Music selectById(Integer id);

    @Delete("delete from music where id = #{id}")
    int deleteById(Integer id);
}
