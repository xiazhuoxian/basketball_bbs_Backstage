package com.xiazhuoxian.bbs.service;

import com.xiazhuoxian.bbs.pojo.News;
import com.xiazhuoxian.bbs.pojo.Paging;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface NewsService {
    public Paging newsPagingSelect(int currentPageNumber,String selectCondition);
    public int insertNews(int posterId, int plateId, int unionId, MultipartFile cover, String title, String content)throws IOException;
    public int deleteNewsById(int newsId);
    public int updateNews(int newsId,int posterId,int plateId,int unionId,String cover,String title,String content);
    public News selectNewsById(int newsId);
    public List<News> selectTheLastNews();
    public List<News> selectTheHotNews();
}
