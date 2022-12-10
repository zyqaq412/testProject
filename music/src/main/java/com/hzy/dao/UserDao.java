package com.hzy.dao;

import com.hzy.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    User selectByName(String username);

    /**
     * 验证登录
     * @param user
     * @return
     */
    @Select("select * from user where username=#{username} and password=#{password} ")
    User selectByNameAndPassword(User user);

    /**
     *推荐用户
     * @param user
     * @return
     */
    @Insert("insert into user values (null,#{username},#{password})")
    int addByUser(User user);

    /**
     * 查询 username 的id
     * @param username
     * @return
     */
    @Select("select id from user where username=#{username}")
    int selectByNamerId(String username);
}
