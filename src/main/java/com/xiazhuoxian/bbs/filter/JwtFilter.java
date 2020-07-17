package com.xiazhuoxian.bbs.filter;

import com.auth0.jwt.interfaces.Claim;
import com.xiazhuoxian.bbs.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

//JWT过滤器，拦截 所有的请求
@Slf4j
@WebFilter(filterName = "JwtFilter", urlPatterns = "/*")
public class JwtFilter implements Filter {
    //过滤器排除URL的列表，/static为静态资源路径，与spring： mvc： static-path-pattern: /static/** 相匹配
    private static final String[] str=new String[]{
            "/admin/login", "/upload","/static","/user/login","/user/insertUser",
            "/mainPosts","/mainPostsComments","/news/newsPagingSelect","/news/selectNewsById",
            "/video/videoPagingSelect","/video/selectVideoById","/matchSchedule/matchSchedulePagingSelect",
            "/team/selectTeamInfoByUnion","/matchSchedule/selectMatchScheduleById","/team/selectTeamInfoById",
            "/team/selectTheLastTeamAverageData","/matchSchedule/selectTheLastTenMatchScheduleByTeamId",
            "/player/selectPlayerSingleMatchDataByMatchId","/player/playerInfoSelect",
            "/player/selectPlayInfoById","/player/selectTheLastPlayerAverageData","/player/selectTheLastTenPlayerSingleMatchDataByPlayerId",
            "/player/selectAllPlayerAverageData","/admin/selectHomePageCarousel","/news/selectTheLastNews",
            "/video/selectTheLastVideo","/news/selectTheHotNews","/video/selectTheHotVideo","/websocket"
    };
    //初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        response.setCharacterEncoding("UTF-8");
        //获取 header里的token
        final String token = request.getHeader("Authorization");
        //获取url
        String path = request.getRequestURI();
        boolean allowedPath=false;
        //循环判断URL与需要排除的特定URL是否匹配，当URL包含特定的需要排除的URL时，contains()返回true
        for (int i=0;i<str.length;i++){
            allowedPath=path.contains(str[i]);
            if (allowedPath==true){
                break;
            }
        }
        //使用 OPTIONS 方法的预检请求
        if ("OPTIONS".equals(request.getMethod())) {
            // Except OPTIONS, other request should be checked by JWT
            response.setStatus(HttpServletResponse.SC_OK);
            //chain.doFilter(request, response);
            return;
        }else if(allowedPath){//过滤特定的URL
            //if判断，如果是特定的URL，则排除，不进行token验证
            chain.doFilter(request, response);
        }
        else {
            if (token == null) {
                response.getWriter().write("没有token！");
                return;
            }
            //解析token
            Map<String, Claim> userData = JwtUtil.verifyToken(token);
            //判断token是否合法，不合法则解析结果为空
            if (userData == null) {
                response.getWriter().write("401");
                return;
                //throw new RuntimeException("401");
            }
            //获取token中的有效负载
            Integer id = userData.get("id").asInt();
            String loginName = userData.get("loginName").asString();
            String nickname = userData.get("nickname").asString();
            //拦截器 拿到用户信息，放到request中
            request.setAttribute("id", id);
            request.setAttribute("loginName", loginName);
            request.setAttribute("nickname", nickname);
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
    }
}

