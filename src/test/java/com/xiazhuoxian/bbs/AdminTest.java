package com.xiazhuoxian.bbs;

import com.xiazhuoxian.bbs.controller.AdminController;
import com.xiazhuoxian.bbs.pojo.AdminInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminTest extends BbsApplicationTests {

    @Autowired
    private AdminController adminController;

    @Test
    public void searchAdminByLoginName(){
        /*Assert.assertSame("1",adminController.searchAdminByLoginName("xiazhuoxian"));*/
        AdminInfo adminInfo=adminController.searchAdminByLoginName("xiazhuoxian");
        System.out.println(adminInfo.getAdminId());
        System.out.println(adminInfo.getLoginName());
        System.out.println(adminInfo.getLoginPassword());
        System.out.println(adminInfo.getAddress());
    }
}
