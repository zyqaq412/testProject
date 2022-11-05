package com.studentTest.dao;

import com.studentTest.bean.User;
import com.studentTest.util.JDBC;

import java.sql.*;

public class LoginDaoImpl implements loginDao{
    Connection conn=null;
    Statement stmt=null;
    ResultSet rs =null;

    @Override
    public User logindao(User u) {
        //数据库
        /*int id = u.getU_id();
        String pwd = u.getU_pwd();
        User user =new User(1001,"黄哲宇","120125","17623247012",1,0);*/

         int id = u.getU_id();
         String pwd = u.getU_pwd();

         try {
              conn = JDBC.getConnection();
              stmt = conn.createStatement();
             String sql = "select * from user where u_id="+id+" and u_pwd='"+pwd+"'";
              rs = stmt.executeQuery(sql);
             while (rs.next()){
                 User user = new User();
                 user.setU_id(rs.getInt("u_id"));
                 user.setU_name(rs.getString("u_name"));
                 user.setU_pwd(rs.getString("u_pwd"));
                 user.setU_phone(rs.getString("u_phone"));
                 user.setRole(rs.getInt("u_role"));
                 user.setAddress(rs.getString("u_address"));
                 return user;
             }

         }catch (SQLException throwables) {
             System.out.println("失败");
             throwables.printStackTrace();
         }
        JDBC.close(conn,stmt,rs);
         return null;

    }
}
