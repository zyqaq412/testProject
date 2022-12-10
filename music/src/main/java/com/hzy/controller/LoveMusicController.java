package com.hzy.controller;

import com.hzy.pojo.Music;
import com.hzy.pojo.User;
import com.hzy.service.LoveMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

/**
 * @title: LoveMusicController
 * @Author zxwyhzy
 * @Date: 2022/12/10 14:18
 * @Version 1.0
 */
@RestController
@RequestMapping("/lovemusic")
public class LoveMusicController {

    @Autowired
    LoveMusicService loveMusicService;

    @GetMapping("/likemusic/{musicId}")
    public Result likeMusic(@PathVariable String musicId, HttpServletRequest request){
        //System.out.println("musicId: "+musicId);

        //1. 检查是否登录了
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(Code.SESSION_OK) == null) {
            System.out.println("没有登录");
            return new Result(Code.SAVE_ERR, null, "请先登录");
        }
        User user = (User) session.getAttribute(Code.SESSION_OK);
        int userId = user.getId();
        System.out.println("userId: "+userId);

        boolean b = loveMusicService.selectByUserIdAndMusicId(userId, Integer.valueOf(musicId));

        if (b){
            return new Result(Code.SAVE_ERR, null, "已收藏");
        }else {
            boolean b1 = loveMusicService.addLoveMusic(Integer.valueOf(musicId), userId);
            if (b1){
                return new Result(Code.SAVE_OK, null, "收藏成功");
            }else return new Result(Code.SAVE_ERR, null, "收藏失败");
        }

    }
    /**
     * 查询收藏音乐
     * @param
     * @return
     */
    @PostMapping ("/selectMusic")
    public Result findMusic(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(Code.SESSION_OK) == null) {

            return new Result(Code.GET_ERR, null, "请先登录");
        }
        User user = (User) session.getAttribute(Code.SESSION_OK);
        int userId = user.getId();
        List<Music> musicList = loveMusicService.selectAllLoveMusic(userId);
        return new Result(Code.GET_OK,musicList,"收藏音乐查询成功");

    }
    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteMusicById(@PathVariable Integer id,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(Code.SESSION_OK) == null) {
            return new Result(Code.DELETE_ERR, null, "请先登录");
        }
        User user = (User) session.getAttribute(Code.SESSION_OK);
        int userId = user.getId();
        boolean b1 = loveMusicService.selectByMusicIdAndUserId(userId, id);
        if (b1){
            boolean b = loveMusicService.deleteByMusicIdAndUserId(userId, id);
            if (b){
                return new Result(Code.DELETE_OK,null,"取消收藏成功");
            }else {
                return new Result(Code.DELETE_ERR,null,"取消收藏失败");
            }
        }else {
            return new Result(Code.DELETE_ERR,null,"未收藏该歌曲");
        }
    }
}
