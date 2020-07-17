package com.xiazhuoxian.bbs.controller;

import com.xiazhuoxian.bbs.pojo.*;
import com.xiazhuoxian.bbs.service.AdminService;
import com.xiazhuoxian.bbs.util.JwtUtil;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    UploadController uploadController;

    @RequestMapping("/selectAdminByLoginName")
    @ResponseBody
    public AdminInfo searchAdminByLoginName(String loginName){
        log.info("管理员：{}，查询个人信息",loginName);
        AdminInfo adminInfo= adminService.selectAdminByLoginName(loginName);
        return adminInfo;
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String loginName,String loginPassword){
        log.info("管理员：{}，尝试登陆",loginName);
        String token="error";
        AdminInfo adminInfo= adminService.selectAdminByLoginName(loginName);
        if (adminInfo==null){
            return token;
        }else if(loginName.equals(adminInfo.getLoginName())&&loginPassword.equals(adminInfo.getLoginPassword())){
            //签发token
            token=JwtUtil.createAdminToken(adminInfo);
        }
        log.info("token:",token);
        return token;
    }

    @RequestMapping("/updateAdminInfo")
    @ResponseBody
    private int updateAdminInfo(AdminInfo adminInfo){
        log.info("管理员：{}，修改个人资料",adminInfo.getLoginName());
        return adminService.updateAdminInfo(adminInfo);
    }

    @RequestMapping("/updateIcon")
    @ResponseBody
    private int updateIcon(@RequestParam("file")MultipartFile file,int adminId)throws IOException {
        log.info("管理员：{}，修改头像");
        String iconAddress=uploadController.uploadIcon(file);
        return adminService.updateIcon(adminId,iconAddress);
    }

    @RequestMapping("/selectHomePageCarousel")
    @ResponseBody
    public List<HomePageCarousel> selectHomePageCarousel(){
        return adminService.selectHomePageCarousel();
    }

    @RequestMapping("/selectHomePageCarouselById")
    @ResponseBody
    public HomePageCarousel selectHomePageCarouselById(int id){
        return adminService.selectHomePageCarouselById(id);
    }

    @RequestMapping("/updateHomePageCarousel")
    @ResponseBody
    public int updateHomePageCarousel(HomePageCarousel homePageCarousel){
        return adminService.updateHomePageCarousel(homePageCarousel);
    }
}
