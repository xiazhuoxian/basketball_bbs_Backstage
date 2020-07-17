package com.xiazhuoxian.bbs.mapper;

import com.xiazhuoxian.bbs.pojo.Paging;
import com.xiazhuoxian.bbs.pojo.Video;

import java.util.List;

public interface VideoMapper {
    public List<Video> videoPagingSelect(Paging paging);
    public int insertVideo(Video video);
    public int deleteVideoById(int videoId);
    public int updateVideo(Video video);
    public Video selectVideoById(int videoId);
    public List<Video> selectTheLastVideo();
    public List<Video> selectTheHotVideo();
}
