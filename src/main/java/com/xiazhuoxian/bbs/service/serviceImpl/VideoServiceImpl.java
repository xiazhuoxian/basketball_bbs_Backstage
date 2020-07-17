package com.xiazhuoxian.bbs.service.serviceImpl;

import com.xiazhuoxian.bbs.controller.UploadController;
import com.xiazhuoxian.bbs.mapper.VideoMapper;
import com.xiazhuoxian.bbs.pojo.*;
import com.xiazhuoxian.bbs.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;
    @Autowired
    UploadController uploadController;

    @Override
    public Paging videoPagingSelect(int currentPageNumber, String selectCondition){
        int itemsDisplayedPerPage=10;
        Paging paging=new Paging(currentPageNumber,itemsDisplayedPerPage,selectCondition);

        List<Video> result=videoMapper.videoPagingSelect(paging);
        for(Video param : result){
            Timestamp timestamp=param.getUpdateTime();
            param.setUpdateDate(new java.sql.Date(timestamp.getTime()));
            param.setTime(new java.sql.Time(timestamp.getTime()));
        }

        paging.setVideoResult(result);
        paging.setTotalItems(paging.getVideoResult().size());
        paging.setTotalPages(paging.getTotalItems()%itemsDisplayedPerPage==0?
                paging.getTotalItems()/itemsDisplayedPerPage:
                paging.getTotalItems()/itemsDisplayedPerPage+1);
        return paging;
    }

    @Override
    public int insertVideo(int posterId, int plateId, int unionId, MultipartFile cover, String title, String content, MultipartFile videoFile)throws IOException {
        AdminInfo admin= new AdminInfo(posterId);
        PlateClassification plateClassification=new PlateClassification(plateId);
        UnionClassification unionClassification=new UnionClassification(unionId);
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String coverAddress=uploadController.cover(cover);
        String fileAddress=uploadController.uploadVideoFile(videoFile);
        Video video=new Video(plateClassification,unionClassification,coverAddress,title,fileAddress,content,admin,0,0,0,0,Timestamp.valueOf(nowTime));
        return videoMapper.insertVideo(video);
    }

    @Override
    public int deleteVideoById(int videoId){
        return videoMapper.deleteVideoById(videoId);
    };

    @Override
    public int updateVideo(int videoId,int posterId,int plateId,int unionId,String cover,String title,String content,String videoAddress){
        AdminInfo admin= new AdminInfo(posterId);
        PlateClassification plateClassification=new PlateClassification(plateId);
        UnionClassification unionClassification=new UnionClassification(unionId);
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Video video=new Video(videoId,plateClassification,unionClassification,cover,title,videoAddress,content,admin,0,0,0,0,Timestamp.valueOf(nowTime));
        return videoMapper.updateVideo(video);
    }

    @Override
    public Video selectVideoById(int videoId){
        Video param=videoMapper.selectVideoById(videoId);
        Timestamp timestamp=param.getUpdateTime();
        param.setUpdateDate(new java.sql.Date(timestamp.getTime()));
        param.setTime(new java.sql.Time(timestamp.getTime()));
        return param;
    }

    @Override
    public List<Video> selectTheLastVideo(){
        return videoMapper.selectTheLastVideo();
    }

    @Override
    public List<Video> selectTheHotVideo(){
        return videoMapper.selectTheHotVideo();
    }
}
