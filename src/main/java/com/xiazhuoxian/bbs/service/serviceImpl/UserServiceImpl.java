package com.xiazhuoxian.bbs.service.serviceImpl;

import com.xiazhuoxian.bbs.enums.IdentityEnum;
import com.xiazhuoxian.bbs.enums.SexEnum;
import com.xiazhuoxian.bbs.enums.StatusEnum;
import com.xiazhuoxian.bbs.mapper.UserMapper;
import com.xiazhuoxian.bbs.pojo.Paging;
import com.xiazhuoxian.bbs.pojo.UserInfo;
import com.xiazhuoxian.bbs.pojo.Video;
import com.xiazhuoxian.bbs.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int insertUser(String loginName,String loginPassword,String nickname,String address,String phone,String sex,String icon,String secretProtectionQuestion,String secretProtectionAnswer){
        String status="NORMAL";
        String identity="USER";
        SexEnum sexEnum=SexEnum.valueOf(sex);
        StatusEnum statusEnum=StatusEnum.valueOf(status);
        IdentityEnum identityEnum=IdentityEnum.valueOf(identity);
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Timestamp createTime=Timestamp.valueOf(nowTime);
        Timestamp updateTime=Timestamp.valueOf(nowTime);
        UserInfo userInfo=new UserInfo(loginName,loginPassword,nickname,address,phone,sexEnum,icon,secretProtectionQuestion,secretProtectionAnswer,createTime,updateTime,statusEnum,identityEnum);
        return userMapper.insertUser(userInfo);
    }

    @Override
    public int deleteUserById(int userId){
        return userMapper.deleteUserById(userId);
    }

    @Override
    public int updateUserInfo(int userId,String loginPassword,String nickname,String address,String phone,String sex,String icon,String secretProtectionQuestion,String secretProtectionAnswer){
        UserInfo userInfo=userMapper.selectUserById(userId);
        userInfo.setLoginPassword(loginPassword);
        userInfo.setNickname(nickname);
        userInfo.setAddress(address);
        userInfo.setPhone(phone);
        userInfo.setSex(SexEnum.valueOf(sex));
        userInfo.setIcon(icon);
        userInfo.setSecretProtectionQuestion(secretProtectionQuestion);
        userInfo.setSecretProtectionAnswer(secretProtectionAnswer);
        return userMapper.updateUserInfo(userInfo);
    }

    @Override
    public int updateIcon(int userId,String icon){
        UserInfo userInfo=new UserInfo(userId,icon);
        return userMapper.updateIcon(userInfo);
    }

    @Override
    public UserInfo selectUserById(int userId){
        return userMapper.selectUserById(userId);
    }

    @Override
    public UserInfo selectUserByLoginName(String loginName){
        return userMapper.selectUserByLoginName(loginName);
    }

    @Override
    public Paging userPagingSelect(int currentPageNumber,String selectCondition){
        int itemsDisplayedPerPage=10;
        Paging paging=new Paging(currentPageNumber,itemsDisplayedPerPage,selectCondition);

        List<UserInfo> result=userMapper.userPagingSelect(paging);
        for(UserInfo param : result){
            Timestamp timestamp=param.getUpdateTime();
            param.setCreateDate(new java.sql.Date(timestamp.getTime()));
            param.setTime(new java.sql.Time(timestamp.getTime()));
        }

        paging.setUserResult(result);
        paging.setTotalItems(paging.getUserResult().size());
        paging.setTotalPages(paging.getTotalItems()%itemsDisplayedPerPage==0?
                paging.getTotalItems()/itemsDisplayedPerPage:
                paging.getTotalItems()/itemsDisplayedPerPage+1);
        return paging;
    }
}
