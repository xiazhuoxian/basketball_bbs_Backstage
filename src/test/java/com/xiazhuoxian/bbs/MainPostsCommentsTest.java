package com.xiazhuoxian.bbs;

import com.xiazhuoxian.bbs.controller.MainPostsCommentsController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MainPostsCommentsTest extends BbsApplicationTests{
    @Autowired
    MainPostsCommentsController mainPostsCommentsController;
    @Test
    public void test(){
        int currentPageNumber=1;
        String selectCondition=null;
        Integer mainPostsId=9;
        String plateClassification=null;
        String unionClassification=null;
        String communityClassification=null;
        String posterIdentity=null;
        Integer posterId=null;
        Integer headCommentId=0;
        mainPostsCommentsController.mainPostsCommentsPagingSelect(currentPageNumber,selectCondition,mainPostsId,plateClassification,unionClassification,communityClassification,posterIdentity,posterId,headCommentId);
    }
}
