package com.hzy.service;

import com.hzy.pojo.Res;

import java.util.List;

public interface ResService {
    List<Res> selectByIdAll(Integer id);

    boolean insertSq(Res res);
}
