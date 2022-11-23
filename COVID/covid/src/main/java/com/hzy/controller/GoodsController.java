package com.hzy.controller;

import com.hzy.pojo.Goods;
import com.hzy.pojo.Temp;
import com.hzy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: GoodsController
 * @Author zxwyhzy
 * @Date: 2022/11/22 15:30
 * @Version 1.0
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @GetMapping
    public Result selectAll(){
        List<Goods> goods = goodsService.selectAll();
        return new Result(Code.GET_OK,goods,"查询成功");
    }

}
