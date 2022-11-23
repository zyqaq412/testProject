package com.hzy.dao;

import com.hzy.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeacherDao {
    @Select("select tid,tname,password,bid,level from teacher where tid = #{tid} and password = #{password}")
    Teacher login(Teacher teacher);
}
