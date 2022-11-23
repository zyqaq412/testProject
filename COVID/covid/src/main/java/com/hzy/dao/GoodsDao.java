package com.hzy.dao;

import com.hzy.pojo.Goods;
import com.hzy.pojo.Temp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @title: GoodsDao
 * @Author zxwyhzy
 * @Date: 2022/11/22 15:26
 * @Version 1.0
 */
@Mapper
public interface GoodsDao {
    @Select("select wid, wname,wcount,time from goods")
    List<Goods> selectAll();

    @Update("update goods set wcount = (wcount - #{num}) WHERE wid = #{wid} ")
    int rqUpdate(Temp temp);
}
