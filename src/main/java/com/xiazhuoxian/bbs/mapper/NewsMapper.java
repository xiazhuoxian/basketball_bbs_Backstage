package com.xiazhuoxian.bbs.mapper;

import com.xiazhuoxian.bbs.pojo.News;
import com.xiazhuoxian.bbs.pojo.Paging;

import java.util.List;

public interface NewsMapper {
    public List<News> newsPagingSelect(Paging paging);
    public int insertNews(News news);
    public int deleteNewsById(int newsId);
    public int updateNews(News news);
    public News selectNewsById(int newsId);
    public List<News> selectTheLastNews();
    public List<News> selectTheHotNews();
}
