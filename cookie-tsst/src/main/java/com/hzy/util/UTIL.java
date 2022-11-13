package com.hzy.util;

import java.io.UnsupportedEncodingException;

/**
 * @title: UTIL
 * @Author zxwyhzy
 * @Date: 2022/11/12 17:41
 * @Version 1.0
 */
public class UTIL {
    public static String luanMa(String str){
        try {
            byte[] bytes = str.getBytes("ISO-8859-1");
            String s = new String(bytes,"utf-8");
            return s;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
