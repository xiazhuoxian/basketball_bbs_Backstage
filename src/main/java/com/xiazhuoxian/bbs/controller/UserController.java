package com.xiazhuoxian.bbs.controller;

import com.xiazhuoxian.bbs.pojo.Paging;
import com.xiazhuoxian.bbs.pojo.UserInfo;
import com.xiazhuoxian.bbs.service.UserService;
import com.xiazhuoxian.bbs.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UploadController uploadController;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String loginName,String loginPassword){
        log.info("用户：{}，尝试登陆",loginName);
        String token="error";
        UserInfo userInfo= userService.selectUserByLoginName(loginName);
        if (userInfo==null){
            return token;
        }else if(loginName.equals(userInfo.getLoginName())&&loginPassword.equals(userInfo.getLoginPassword())){
            //签发token
            token=JwtUtil.createUserToken(userInfo);
        }
        log.info("token:",token);
        return token;
    }

    @RequestMapping("/loginStatus")
    @ResponseBody
    public int loginStatus(){
        return 1;
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public int insertUser(String loginName,String loginPassword,String nickname,String address,String phone,String sex,String icon,String secretProtectionQuestion,String secretProtectionAnswer){
        log.info("用户：{}，注册",loginName);
        return userService.insertUser(loginName,loginPassword,nickname,address,phone,sex,icon,secretProtectionQuestion,secretProtectionAnswer);
    }

    @RequestMapping("/deleteUserById")
    @ResponseBody
    public int deleteUserById(int userId){
        log.info("用户：{}，删除",userId);
        return userService.deleteUserById(userId);
    }

    @RequestMapping("/updateUserInfo")
    @ResponseBody
    private int updateUserInfo(int userId,String loginPassword,String nickname,String address,String phone,String sex,String icon,String secretProtectionQuestion,String secretProtectionAnswer){
        log.info("用户：{}，修改个人资料",userId);
        return userService.updateUserInfo(userId,loginPassword,nickname,address,phone,sex,icon,secretProtectionQuestion,secretProtectionAnswer);
    }

    @RequestMapping("/updateIcon")
    @ResponseBody
    private int updateIcon(@RequestParam("file")MultipartFile file, int userId)throws IOException {
        log.info("用户：{}，修改头像",userId);
        String iconAddress=uploadController.uploadIcon(file);
        return userService.updateIcon(userId,iconAddress);
    }

    @RequestMapping("/selectUserById")
    @ResponseBody
    public UserInfo selectUserById(int userId){
        log.info("用户：{}，查询个人信息",userId);
        UserInfo userInfo= userService.selectUserById(userId);
        return userInfo;
    }

    @RequestMapping("/selectUserByLoginName")
    @ResponseBody
    public UserInfo selectUserByLoginName(String loginName){
        log.info("用户：{}，查询个人信息",loginName);
        UserInfo userInfo= userService.selectUserByLoginName(loginName);
        return userInfo;
    }

    @RequestMapping("/userPagingSelect")
    @ResponseBody
    public Paging userPagingSelect(@RequestParam("currentPageNumber") int currentPageNumber,
                                   @RequestParam(value = "selectCondition",required = false) String selectCondition){
        System.out.println("分页查询用户");
        return userService.userPagingSelect(currentPageNumber,selectCondition);
    }
}
