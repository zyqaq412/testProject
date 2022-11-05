package com.studentTest.util;

import com.studentTest.bean.Major;
import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class Test03 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs =null;
        int a1 = 1060;
        String a2 = "hh";
        String a3 = "123";
        String a4 = "100";
        String a5 = "晒海";
        int a6 = 1;
        String sql = "insert into user value("+a1+','+'"'+
                a2+'"'+','+'"'+a3+'"'+','+'"'+a4+'"'+','+'"'+a5+'"'+','+a6+')';
        System.out.println(sql);
        Random random = new Random();
        try {
            conn = JDBC.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);




            /*for (int i = 1004;i<1020;i++){
                String sql = "insert into user values ("+i+",1,1,1,1,1)";
                stmt.executeUpdate(sql);
                for (int j = 1001;j<=1004;j++){
                    int number = random.nextInt(100);
                    String sql1 = "insert into usercourse values ("+i+','+j+','+number+')';
                    stmt.executeUpdate(sql1);
                }
            }*/


        }catch (SQLException throwables) {
            System.out.println("失败5");
            throwables.printStackTrace();
        }
        JDBC.close(conn,stmt,rs);

    }
    private static char randomChar(){
        return (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
    }
}
