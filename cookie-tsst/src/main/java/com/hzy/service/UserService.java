package com.hzy.service;

import com.hzy.mapper.UserMapper;
import com.hzy.pojo.User;
import com.hzy.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @title: UserService
 * @Author zxwyhzy
 * @Date: 2022/11/13 20:58
 * @Version 1.0
 */
public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
    public User login(User user){
        //获取 sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = mapper.select(user.getUsername(), user.getPassword());
        sqlSession.close();
        return u;
    }

    public User selectByUsername(String username){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByUsername(username);
        sqlSession.close();
        return user;
    }
    public void add(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.add(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
