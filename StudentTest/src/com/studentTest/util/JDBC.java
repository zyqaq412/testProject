package com.studentTest.util;

import java.sql.*;

public class JDBC {
    static String url = "jdbc:mysql://localhost:3306/studenttest?&useSSL=false&serverTimezone=UTC";
    static String user = "root";
    static String password = "123456" ;

    private JDBC(){}
    public static Connection getConnection() throws SQLException {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
           // System.out.println("驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(url,user,password);
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
                //System.out.println("rs关闭");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt != null){
            try {
                stmt.close();
                //System.out.println("stmt关闭");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
                //System.out.println("conn关闭");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
