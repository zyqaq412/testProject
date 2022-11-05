package com.studentTest.util;

import com.studentTest.bean.User;
import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;

public class Test02 {
    public static void main(String[] args) {
        //String v = "1001";
        //int studentId = 1001;
        //System.out.println("select * from user where u_name='"+v+"'"+" or"+" u_id='"+v+"'");
        //System.out.println("select  c_name as '课程', c_score as '成绩' from "+"" +
            //    "course, usercourse where course.c_id=usercourse.c_id and usercourse.u_id="+studentId);
        /*String id = "1";
        FileService fs2 = new FileServiceImpl();
        User adminU = fs2.getAdmin(id);
        System.out.println(adminU);*/
        //int studentId = 1004;
        /*int i = 1;
        int j = 1;
        int number = 1;
        //System.out.println("delete form user where u_id="+studentId);
        System.out.println("insert into usercourse values ("+i+','+j+','+number+')');*/
        System.out.println(args[0]);
        System.out.println(args[1]);
    }
}
