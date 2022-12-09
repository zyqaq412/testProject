package com.hzy.dao;

import com.hzy.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from user where username = #{username}")
    User selectByName(String username);

    @Select("select * from user where username=#{username} and password=#{password} ")
    User selectByNameAndPassword(User user);

    @Insert("insert into user values (null,#{username},#{password})")
    int addByUser(User user);
    @Select("select id from user where username=#{username}")
    int selectByNamerId(String username);
}
