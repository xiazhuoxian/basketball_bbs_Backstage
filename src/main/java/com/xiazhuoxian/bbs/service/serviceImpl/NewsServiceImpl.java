package com.xiazhuoxian.bbs.service.serviceImpl;


import com.xiazhuoxian.bbs.controller.UploadController;
import com.xiazhuoxian.bbs.mapper.NewsMapper;
import com.xiazhuoxian.bbs.pojo.*;
import com.xiazhuoxian.bbs.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsMapper newsMapper;
    @Autowired
    UploadController uploadController;

    @Override
    public Paging newsPagingSelect(int currentPageNumber,String selectCondition){
        int itemsDisplayedPerPage=10;
        Paging paging=new Paging(currentPageNumber,itemsDisplayedPerPage,selectCondition);

        List<News> result=newsMapper.newsPagingSelect(paging);
        for(News param : result){
            Timestamp timestamp=param.getUpdateTime();
            param.setUpdateDate(new java.sql.Date(timestamp.getTime()));
            param.setTime(new java.sql.Time(timestamp.getTime()));
        }

        paging.setNewsResult(result);
        paging.setTotalItems(paging.getNewsResult().size());
        paging.setTotalPages(paging.getTotalItems()%itemsDisplayedPerPage==0?
                paging.getTotalItems()/itemsDisplayedPerPage:
                paging.getTotalItems()/itemsDisplayedPerPage+1);
        return paging;
    }

    @Override
    public int insertNews(int posterId, int plateId, int unionId, MultipartFile cover, String title, String content) throws IOException {
        AdminInfo admin= new AdminInfo(posterId);
        PlateClassification plateClassification=new PlateClassification(plateId);
        UnionClassification unionClassification=new UnionClassification(unionId);
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String file=uploadController.cover(cover);
        News news=new News(plateClassification,unionClassification,file,title,content,admin,0,0,0,0,Timestamp.valueOf(nowTime));
        return newsMapper.insertNews(news);
    }

    @Override
    public int deleteNewsById(int newsId){
        return newsMapper.deleteNewsById(newsId);
    };

    @Override
    public int updateNews(int newsId,int posterId,int plateId,int unionId,String cover,String title,String content){
        AdminInfo admin= new AdminInfo(posterId);
        PlateClassification plateClassification=new PlateClassification(plateId);
        UnionClassification unionClassification=new UnionClassification(unionId);
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        News news=new News(newsId,plateClassification,unionClassification,cover,title,content,admin,0,0,0,0,Timestamp.valueOf(nowTime));
        return newsMapper.updateNews(news);
    }

    @Override
    public News selectNewsById(int newsId){
        return newsMapper.selectNewsById(newsId);
    }

    @Override
    public List<News> selectTheLastNews(){
        return newsMapper.selectTheLastNews();
    }

    @Override
    public List<News> selectTheHotNews(){
        return newsMapper.selectTheHotNews();
    }
}
