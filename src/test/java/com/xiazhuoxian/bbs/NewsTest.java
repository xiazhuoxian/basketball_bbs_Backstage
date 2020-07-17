package com.xiazhuoxian.bbs;

import com.xiazhuoxian.bbs.controller.NewsController;
import com.xiazhuoxian.bbs.pojo.Paging;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsTest extends BbsApplicationTests {
    @Autowired
    private NewsController newsController;
    @Test
    public void newsPagingSelect(){
        Paging paging=newsController.newsPagingSelect(1,"1");
        System.out.println(paging.getTotalItems());
        for(int i=0;i<=paging.getTotalItems();i++){
            System.out.println(paging.getNewsResult());
        }
    }
}
