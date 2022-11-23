package com.hzy.service.impl;

import com.hzy.dao.GoodsDao;
import com.hzy.pojo.Goods;
import com.hzy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: GoodsServiceImpl
 * @Author zxwyhzy
 * @Date: 2022/11/22 15:29
 * @Version 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;
    @Override
    public List<Goods> selectAll() {
        return goodsDao.selectAll();
    }
}
