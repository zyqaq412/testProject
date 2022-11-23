package com.hzy.util;

import com.hzy.controller.Code;
import com.hzy.pojo.Student;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @title: UTIL
 * @Author zxwyhzy
 * @Date: 2022/11/22 15:13
 * @Version 1.0
 */
public class UTIL {
    public static String getTime(){
        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m:s");
        String nowTimestr= sdf.format(nowTime);
        return nowTimestr;
    }
    public static int getDlId(HttpServletRequest request){
      Student student = (Student) request.getSession().getAttribute(Code.SESSION_OK);
      return student.getSid();
    }

}
