package com.hzy.dao;


import com.hzy.pojo.Res;
import com.hzy.pojo.Temp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ResDao {
    @Select("select * from res where res.sid=#{id}")
    List<Res> selectByIdAll(Integer id);
    @Insert("insert into res values (#{sid},#{wid},#{count},#{bid},#{wname},#{status})")
    int insertSq(Res res);
}
