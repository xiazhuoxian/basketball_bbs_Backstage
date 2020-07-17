package com.xiazhuoxian.bbs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 需要登录后才能访问
 */
@Slf4j
@RestController
public class SecureController {

    /**
     * 查询 用户信息，登录后才能访问
     */
    @RequestMapping("/secure/getUserInfo")
    public String login(HttpServletRequest request) {
        log.info("getUserInfo");
        //获取token中的有效负载
        Integer id = (Integer) request.getAttribute("id");
        String loginName = request.getAttribute("loginName").toString();
        log.info("当前用户信息id=" + id + ",userName=" + loginName);
        return "当前用户信息id=" + id + ",userName=" + loginName;
    }
}

