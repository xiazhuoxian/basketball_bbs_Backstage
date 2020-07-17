package com.xiazhuoxian.bbs.service;

import com.xiazhuoxian.bbs.pojo.Paging;
import com.xiazhuoxian.bbs.pojo.Video;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    public Paging videoPagingSelect(int currentPageNumber, String selectCondition);
    public int insertVideo(int posterId,int plateId,int unionId,MultipartFile cover,String title,String content,MultipartFile videoFile)throws IOException;
    public int deleteVideoById(int videoId);
    public int updateVideo(int videoId,int posterId,int plateId,int unionId,String cover,String title,String content,String videoAddress);
    public Video selectVideoById(int videoId);
    public List<Video> selectTheLastVideo();
    public List<Video> selectTheHotVideo();
}
