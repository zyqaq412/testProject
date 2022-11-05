package com.studentTest.dao;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;
import com.studentTest.util.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FileDaoImpl implements FileDao{
    Connection conn=null; //数据库连接对象
    Statement stmt=null; //sql语句执行对象
    ResultSet rs =null; // 处理结果集
    @Override
    public ArrayList<User> getAllStudent() {
        ArrayList<User> arr = new ArrayList<>();

        try {
             conn = JDBC.getConnection(); //获取数据库连接
             stmt = conn.createStatement();
            //u_role=1,不显示管理员账户
            String sql = "select * from user where u_role=1 ";
             rs = stmt.executeQuery(sql);
            while (rs.next()){
                User user = new User();
                user.setU_id(rs.getInt("u_id"));
                user.setU_name(rs.getString("u_name"));
                user.setU_pwd(rs.getString("u_pwd"));
                user.setU_phone(rs.getString("u_phone"));
                user.setRole(rs.getInt("u_role"));
                user.setAddress(rs.getString("u_address"));
                arr.add(user);
            }
            JDBC.close(conn,stmt,rs);
        }catch (SQLException throwables) {
            System.out.println("失败1");
            throwables.printStackTrace();
        }
        JDBC.close(conn,stmt,rs);
        return arr;

    }

    @Override
    public User getFileByNameOrId(String v) {


        try {
            Connection conn = JDBC.getConnection();
            Statement stmt = conn.createStatement();
            //String sql = "select * from user where u_name='"+v+"'";
            String sql = "select * from user where u_name='"+v+"'"+" or"+" u_id='"+v+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                User user = new User();
                user.setU_id(rs.getInt("u_id"));
                user.setU_name(rs.getString("u_name"));
                user.setU_pwd(rs.getString("u_pwd"));
                user.setU_phone(rs.getString("u_phone"));
                user.setRole(rs.getInt("u_role"));
                user.setAddress(rs.getString("u_address"));
                System.out.println(user);
                return user;

            }


        }catch (SQLException throwables) {
            System.out.println("失败2");
            throwables.printStackTrace();
        }
        return null;

    }

    @Override
    public User getAdmin(String id) {
        try {
             conn = JDBC.getConnection();
             stmt = conn.createStatement();
            String sql = "select * from user where u_id="+id;
             rs = stmt.executeQuery(sql);
            while (rs.next()){
                User user = new User();
                user.setU_id(rs.getInt("u_id"));
                user.setU_name(rs.getString("u_name"));
                user.setRole(rs.getInt("u_role"));

                return user;
            }

        }catch (SQLException throwables) {
            System.out.println("失败3");
            throwables.printStackTrace();
        }
        JDBC.close(conn,stmt,rs);
        return null;
    }


    @Override
    public ArrayList getPersonFile(String studentId) {

        String sql = "select  c_name courseName, c_score score from "+
                "course, usercourse where course.c_id=usercourse.c_id and usercourse.u_id="+studentId;
        ArrayList<Major> arr =new ArrayList<>();
        try {
             conn = JDBC.getConnection();
             stmt = conn.createStatement();

             rs = stmt.executeQuery(sql);


            while (rs.next()){

                Major m = new Major();
                m.setA(rs.getString("courseName"));
                m.setB(rs.getString("score"));
                arr.add(m);

            }
            return arr;

        }catch (SQLException throwables) {
            System.out.println("失败4");
            throwables.printStackTrace();
        }
        JDBC.close(conn,stmt,rs);
        return null;
    }

    @Override
    public void delPersonFile(String studentId) {
        System.out.println("1");
        String sql1 = "delete from user where u_id="+studentId;
        String sql2 = "delete from usercourse where u_id="+studentId;
        try {
            conn = JDBC.getConnection();
            stmt = conn.createStatement();

            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);


        }catch (SQLException throwables) {
            System.out.println("失败5");
            throwables.printStackTrace();
        }
        JDBC.close(conn,stmt,rs);

    }

    @Override
    public void upScore(String stuId, String a1, String a2, String a3, String a4) {

        String[] file = {a1,a2,a3,a4};
        try {
            conn = JDBC.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from usercourse where u_id="+stuId;
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                int index=0;
                for (int i = 1001;i<=1004;i++){
                    String sql1 = "update usercourse set c_score="+file[index]+" where u_id="+stuId+" and c_id="+i;
                    //System.out.println(sql);
                    index++;
                    stmt.executeUpdate(sql1);
                }
            }else {

                int index=0;
                for (int i = 1001;i<=1004;i++){
                    String sql2="insert into usercourse values("+stuId+','+i+','+file[index]+')';
                    //System.out.println(sql);
                    index++;
                    stmt.executeUpdate(sql2);
                }
            }





        }catch (SQLException throwables) {
            System.out.println("失败6");
            throwables.printStackTrace();
        }
        JDBC.close(conn,stmt,rs);

    }

    @Override
    public void addUp(int a1, String a2, String a3, String a4, String a5, int a6) {
        //String sql = "insert into user values("+a1+','+a2+','+a3+','+a4+','+a5+','+a6+')';
        String sql = "insert into user values("+a1+','+'"'+
                a2+'"'+','+'"'+a3+'"'+','+'"'+a4+'"'+','+'"'+a5+'"'+','+a6+')';
        //System.out.println(sql);
        try {
            conn = JDBC.getConnection();
            stmt = conn.createStatement();

            stmt.executeUpdate(sql);

        }catch (SQLException throwables) {
            System.out.println("失败7");
            throwables.printStackTrace();
        }
        JDBC.close(conn,stmt,rs);
    }

    @Override
    public void update(String stuId, String a1, String a2, String a3, String a4) {
        try {
            conn = JDBC.getConnection();
            stmt = conn.createStatement();

            String sql = "update user set u_name='"+a1+"'"+",u_pwd="+a2+",u_phone="+a3+",u_address='"+a4+"'"+
                    " where u_id="+stuId;
            stmt.executeUpdate(sql);

        }catch (SQLException throwables) {
            System.out.println("失败8");
            throwables.printStackTrace();
        }
        JDBC.close(conn,stmt,rs);
    }

}
