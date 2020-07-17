package com.xiazhuoxian.bbs.controller;

import com.xiazhuoxian.bbs.pojo.News;
import com.xiazhuoxian.bbs.pojo.Paging;
import com.xiazhuoxian.bbs.service.NewsService;
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
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @RequestMapping("/newsPagingSelect")
    @ResponseBody
    public Paging newsPagingSelect(@RequestParam("currentPageNumber") int currentPageNumber,
                                   @RequestParam(value = "selectCondition",required = false) String selectCondition){
        return newsService.newsPagingSelect(currentPageNumber,selectCondition);
    }

    @RequestMapping("/insertNews")
    @ResponseBody
    public int insertNews(int posterId, int plateId, int unionId, MultipartFile cover, String title, String content)throws IOException {
        log.info("添加新闻，发布者id："+plateId+",标题："+title+",内容："+content);
        return newsService.insertNews(posterId,plateId,unionId,cover,title,content);
    };

    @RequestMapping("/deleteNewsById")
    @ResponseBody
    public int deleteNewsById(int newsId){
        log.info("删除新闻，id："+newsId);
        return newsService.deleteNewsById(newsId);
    };

    @RequestMapping("/updateNews")
    @ResponseBody
    public int updateNews(int newsId,int posterId,int plateId,int unionId,String cover,String title,String content){
        log.info("修改新闻，发布者id："+plateId+",标题："+title+",内容："+content);
        return newsService.updateNews(newsId,posterId,plateId,unionId,cover,title,content);
    };

    @RequestMapping("/selectNewsById")
    @ResponseBody
    public News selectNewsById(int newsId){
        log.info("通过id查找新闻，新闻id："+newsId);
        return newsService.selectNewsById(newsId);
    };

    @RequestMapping("/selectTheLastNews")
    @ResponseBody
    public List<News> selectTheLastNews(){
        return newsService.selectTheLastNews();
    }

    @RequestMapping("/selectTheHotNews")
    @ResponseBody
    public List<News> selectTheHotNews(){
        return newsService.selectTheHotNews();
    }
}
