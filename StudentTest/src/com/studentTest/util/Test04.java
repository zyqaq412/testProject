package com.studentTest.util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
public class Test04 {
    static String[] xing = {"黄","张","李","唐","刘","王","肖","周","许"};
    static String[] ming = {"德泽","绿芜","洛泱","吟秋","远山","雨晴","昭玥","惊鸿","千晨","诗妤","爱国","知忆","应","齐云"};
    static String[] address = {"重庆","北京","四川","上海","湖南","湖北","广东","广西","缅甸","河南","内蒙古","西藏"};
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs =null;
        Random random = new Random();

        try {
            conn = JDBC.getConnection();
            stmt = conn.createStatement();

            for (int i = 1004;i<1026;i++){
                int index1 = random.nextInt(xing.length);
                int index2 = random.nextInt(ming.length);
                int index3 = random.nextInt(address.length);
                int phone= (int) (1000000+Math.random()*(1999999-1000000+1));

                String name = xing[index1] + ming[index2];
                String address1 = address[index3];
                String sql ="insert into user values("+i+','+'"'+
                        name+'"'+','+'1'+','+'"'+phone+'"'+','+'"'+address1+'"'+','+1+')';
                stmt.executeUpdate(sql);
                for (int j = 1001;j<=1004;j++){
                    int number = random.nextInt(100);
                    String sql1 = "insert into usercourse values ("+i+','+j+','+number+')';
                    stmt.executeUpdate(sql1);
                }
            }


        }catch (SQLException throwables) {
            System.out.println("失败5");
            throwables.printStackTrace();
        }
        JDBC.close(conn,stmt,rs);

    }
}
