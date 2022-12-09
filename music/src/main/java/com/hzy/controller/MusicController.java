package com.hzy.controller;

import com.hzy.pojo.Music;
import com.hzy.pojo.User;
import com.hzy.service.MusicService;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @title: MusicController
 * @Author zxwyhzy
 * @Date: 2022/12/10 0:20
 * @Version 1.0
 */

@RestController
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private MusicService musicService;

    @Value("${music.path}")
    private String savePath;

    @PostMapping("/upload")
    public Result upload(@RequestParam String singer, @RequestParam("file") MultipartFile file,
                         HttpServletRequest request, HttpServletResponse response) {


        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(Code.SESSION_OK) == null) {
            //System.out.println("没有登录");
            return new Result(null,null,"请先登录");
        }

        // 保存文件
        //System.out.println(savePath);D:/Java/Music/

        String fileNameAndType = file.getOriginalFilename();//获取文件名
        System.out.println("fileNameAndType: "+fileNameAndType);

        String path =savePath+fileNameAndType;

        File dest = new File(path);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        // 获取文件的后缀名
        String suffixName = fileNameAndType.substring(fileNameAndType.lastIndexOf("."));
        //System.out.println(suffixName);
        if (!suffixName.equals(".mp3")) return new Result(Code.UPDATE_ERR,null,"不是mp3文件");
        try {
            file.transferTo(dest);

        } catch (IOException e) {
            e.printStackTrace();
            return new Result(Code.UPDATE_ERR,null,"上传失败");
        }

        //数据库插入数据
        //获取歌曲名字
        String title = fileNameAndType.substring(0,fileNameAndType.lastIndexOf('.'));
        User user = (User)session.getAttribute(Code.SESSION_OK);
        int userid = user.getId();

        //点击播放音乐 发送的请求路径
        String url = "/music/get?path="+title+".mp3";

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sf.format(new Date());
        try {
            Music music = new Music();
            music.setTitle(title);
            music.setUrl(url);
            music.setUserid(userid);
            music.setTime(time);
            music.setSinger(singer);
            boolean b = musicService.addMusic(music);
            if (b) {
                //应该跳转到音乐列表页面
                try {
                    response.sendRedirect("/list.html");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new Result(Code.UPDATE_OK, null, "上传成功");
            } else {
                return new Result(Code.UPDATE_ERR, null, "上传失败");
            }
        } catch (BindingException e) {
            dest.delete();
            return new Result(Code.SYSTEM_UNKNOW_ERR,null, "系统错误");
        }

    }
    @GetMapping("/selectMusic")//(required=false)可以不传入参数
    public Result findMusic(@RequestParam(required = false) String musicName){
        List<Music> musicList = null;
        if(musicName != null){
            musicList = musicService.selectByTitle(musicName);
        }else {
            musicList = musicService.selectAll();
        }

        return new Result(Code.GET_OK,musicList,"查询到了所有的音乐");
    }
    /**
     * 播放音乐的时候,/music/get?path=xxx.mp3
     *
     * @param path
     * @return
     */
    @GetMapping("/get")
    public ResponseEntity<byte[]> get(String path) {
        File file = new File(savePath + "/" + path);

        byte[] a = new byte[0];
        try {
            a = Files.readAllBytes(file.toPath());
            if (a.length == 0) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public Result deleteMusicById(@PathVariable Integer id){
        Music music = musicService.selectById(id);
        if (null != music){
            boolean b = musicService.deleteById(id);
            if (b){
                int index = music.getUrl().lastIndexOf("=");
                String fileName = music.getUrl().substring(index + 1);
                File file = new File(savePath + "/" + fileName);
                if (file.delete()){
                    return new Result(Code.DELETE_OK,null,"删除成功");
                }else return new Result(Code.DELETE_ERR,null,"删除失败");
            }else return new Result(Code.DELETE_ERR,null,"删除失败");
        }else {
            return new Result(Code.DELETE_ERR,null,"歌曲不存在");
        }
    }
}
