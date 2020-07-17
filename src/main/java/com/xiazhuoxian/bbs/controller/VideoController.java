package com.xiazhuoxian.bbs.controller;

import com.xiazhuoxian.bbs.pojo.Paging;
import com.xiazhuoxian.bbs.pojo.Video;
import com.xiazhuoxian.bbs.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    VideoService videoService;

    @RequestMapping("/videoPagingSelect")
    @ResponseBody
    public Paging videoPagingSelect(@RequestParam("currentPageNumber") int currentPageNumber,
                                   @RequestParam(value = "selectCondition",required = false) String selectCondition){
        return videoService.videoPagingSelect(currentPageNumber,selectCondition);
    }

    @RequestMapping("/insertVideo")
    @ResponseBody
    public int insertVideo(int posterId, int plateId, int unionId, MultipartFile cover, String title, String content, MultipartFile videoFile)throws IOException {
        log.info("添加视频，发布者id："+plateId+",标题："+title+",内容："+content);
        return videoService.insertVideo(posterId,plateId,unionId,cover,title,content,videoFile);
    };

    @RequestMapping("/deleteVideoById")
    @ResponseBody
    public int deleteVideoById(int videoId){
        log.info("删除视频，id："+videoId);
        return videoService.deleteVideoById(videoId);
    };

    @RequestMapping("/updateVideo")
    @ResponseBody
    public int updateVideo(int videoId,int posterId,int plateId,int unionId,String cover,String title,String content,String videoAddress){
        log.info("修改视频，发布者id："+videoId+",标题："+title+",内容："+content+",视频地址："+videoAddress);
        return videoService.updateVideo(videoId,posterId,plateId,unionId,cover,title,content,videoAddress);
    };

    @RequestMapping("/selectVideoById")
    @ResponseBody
    public Video selectVideoById(int videoId){
        log.info("通过id查找视频，视频id："+videoId);
        return videoService.selectVideoById(videoId);
    };

    @RequestMapping("/selectTheLastVideo")
    @ResponseBody
    public List<Video> selectTheLastVideo(){
        return videoService.selectTheLastVideo();
    }

    @RequestMapping("/selectTheHotVideo")
    @ResponseBody
    public List<Video> selectTheHotVideo(){
        return videoService.selectTheHotVideo();
    }
}
