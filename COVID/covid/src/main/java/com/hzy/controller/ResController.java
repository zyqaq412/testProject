package com.hzy.controller;

import com.hzy.pojo.Res;
import com.hzy.pojo.Student;
import com.hzy.pojo.Temp;
import com.hzy.service.ResService;
import com.hzy.util.UTIL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @title: ResController
 * @Author zxwyhzy
 * @Date: 2022/11/22 17:56
 * @Version 1.0
 */
@RestController
@RequestMapping("/res")
public class ResController {
    @Autowired
    ResService resService;

    @GetMapping
    public Result selectAll(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Student student = (Student) session.getAttribute(Code.SESSION_OK);
        List<Res> res = resService.selectByIdAll(student.getSid());
        return new Result(Code.GET_OK,res,"查询成功");
    }

    @PutMapping()
    public Result sqUpdate(@RequestBody Res res,HttpServletRequest request){
        System.out.println("11");
        Student student = (Student) request.getSession().getAttribute(Code.SESSION_OK);
        res.setSid(UTIL.getDlId(request));
        res.setBid(student.getBid());
        boolean flag = resService.insertSq(res);
        if (flag){
            return new Result(Code.UPDATE_OK,null,"申请成功");
        }
        return new Result(Code.UPDATE_ERR,null,"申请失败");
    }
}
