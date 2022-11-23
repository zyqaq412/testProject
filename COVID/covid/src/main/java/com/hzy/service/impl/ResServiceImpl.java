package com.hzy.service.impl;

import com.hzy.dao.ResDao;
import com.hzy.pojo.Res;
import com.hzy.service.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: ResServiceImpl
 * @Author zxwyhzy
 * @Date: 2022/11/22 17:49
 * @Version 1.0
 */
@Service
public class ResServiceImpl implements ResService {
    @Autowired
    ResDao resDao;

    @Override
    public List<Res> selectByIdAll(Integer id) {
       return resDao.selectByIdAll(id);
    }

    @Override
    public boolean insertSq(Res res) {

        return resDao.insertSq(res) > 0;
    }
}
