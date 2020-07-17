package com.xiazhuoxian.bbs.controller;

import com.xiazhuoxian.bbs.util.WangEditorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/upload")
public class UploadController {
    //String filePath="/usr/local/java/bbsimg";//生产环境上传文件地址
    String filePath="D:\\bbsimg";//开发环境上传文件地址
    //String ip="http://47.102.221.139:8080/static/";//生产环境请求文件地址
    String ip="http://127.0.0.1:8080/static/";//开发环境请求文件地址

    @RequestMapping("/news")
    @ResponseBody
    public WangEditorUtil uploadNews(@RequestParam("files")MultipartFile file)throws IOException {
        log.info("添加新闻图片");
        String originalFilename =file.getOriginalFilename();
        String newFileName=UUID.randomUUID()+originalFilename;
        File targetFile=new File(filePath,newFileName);
        file.transferTo(targetFile);

        String[] str={ip+newFileName};
        WangEditorUtil wangEditorUtil=new WangEditorUtil(str);
        //String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        //mainposts.setImg("http://10.0.2.2:8080/"+newFileName);
        //System.out.println(Timestamp.valueOf(nowTime));
        return wangEditorUtil;
    }

    @RequestMapping("/videoFile")
    @ResponseBody
    public String uploadVideoFile(@RequestParam("file")MultipartFile file)throws IOException {
        log.info("上传视频");
        String originalFilename =file.getOriginalFilename();
        String newFileName=UUID.randomUUID()+originalFilename;
        File targetFile=new File(filePath,newFileName);
        file.transferTo(targetFile);

        String address=ip+newFileName;
        return address;
    }

    @RequestMapping("/video")
    @ResponseBody
    public WangEditorUtil uploadVideo(@RequestParam("files")MultipartFile file)throws IOException {
        log.info("添加视频图片");
        String originalFilename =file.getOriginalFilename();
        String newFileName=UUID.randomUUID()+originalFilename;
        File targetFile=new File(filePath,newFileName);
        file.transferTo(targetFile);

        String[] str={ip+newFileName};
        WangEditorUtil wangEditorUtil=new WangEditorUtil(str);
        return wangEditorUtil;
    }

    @RequestMapping("/icon")
    @ResponseBody
    public String uploadIcon(@RequestParam("file")MultipartFile file)throws IOException {
        log.info("上传头像");
        String originalFilename =file.getOriginalFilename();
        String newFileName=UUID.randomUUID()+originalFilename;
        File targetFile=new File(filePath,newFileName);
        file.transferTo(targetFile);

        String address=ip+newFileName;
        return address;
    }

    @RequestMapping("/mainPosts")
    @ResponseBody
    public WangEditorUtil uploadMainPosts(@RequestParam("files")MultipartFile file)throws IOException {
        log.info("添加主贴图片");
        String originalFilename =file.getOriginalFilename();
        String newFileName=UUID.randomUUID()+originalFilename;
        File targetFile=new File(filePath,newFileName);
        file.transferTo(targetFile);
        String[] str={ip+newFileName};
        WangEditorUtil wangEditorUtil=new WangEditorUtil(str);
        return wangEditorUtil;
    }

    @RequestMapping("/mainPostsComments")
    @ResponseBody
    public WangEditorUtil mainPostsComments(@RequestParam("files")MultipartFile file)throws IOException {
        log.info("添加跟帖图片");
        String originalFilename =file.getOriginalFilename();
        String newFileName=UUID.randomUUID()+originalFilename;
        File targetFile=new File(filePath,newFileName);
        file.transferTo(targetFile);
        String[] str={ip+newFileName};
        WangEditorUtil wangEditorUtil=new WangEditorUtil(str);
        return wangEditorUtil;
    }

    @RequestMapping("/teamIntroduce")
    @ResponseBody
    public WangEditorUtil teamIntroduce(@RequestParam("files")MultipartFile file)throws IOException {
        log.info("球队简介图片");
        String originalFilename =file.getOriginalFilename();
        String newFileName=UUID.randomUUID()+originalFilename;
        File targetFile=new File(filePath,newFileName);
        file.transferTo(targetFile);
        String[] str={ip+newFileName};
        WangEditorUtil wangEditorUtil=new WangEditorUtil(str);
        return wangEditorUtil;
    }

    @RequestMapping("/playerIntroduce")
    @ResponseBody
    public WangEditorUtil playerIntroduce(@RequestParam("files")MultipartFile file)throws IOException {
        log.info("球员简介图片");
        String originalFilename =file.getOriginalFilename();
        String newFileName=UUID.randomUUID()+originalFilename;
        File targetFile=new File(filePath,newFileName);
        file.transferTo(targetFile);
        String[] str={ip+newFileName};
        WangEditorUtil wangEditorUtil=new WangEditorUtil(str);
        return wangEditorUtil;
    }

    @RequestMapping("/matchScheduleReport")
    @ResponseBody
    public WangEditorUtil matchScheduleReport(@RequestParam("files")MultipartFile file)throws IOException {
        log.info("添加赛程简报图片");
        String originalFilename =file.getOriginalFilename();
        String newFileName=UUID.randomUUID()+originalFilename;
        File targetFile=new File(filePath,newFileName);
        file.transferTo(targetFile);
        String[] str={ip+newFileName};
        WangEditorUtil wangEditorUtil=new WangEditorUtil(str);
        return wangEditorUtil;
    }

    @RequestMapping("/privateLetterImg")
    @ResponseBody
    public String privateLetterImg(@RequestParam("file")MultipartFile file)throws IOException {
        log.info("私信图片上传");
        String originalFilename =file.getOriginalFilename();
        String newFileName=UUID.randomUUID()+originalFilename;
        File targetFile=new File(filePath,newFileName);
        file.transferTo(targetFile);

        String address=ip+newFileName;
        return address;
    }

    @RequestMapping("/cover")
    @ResponseBody
    public String cover(@RequestParam("file")MultipartFile file)throws IOException {
        log.info("私信图片上传");
        String originalFilename =file.getOriginalFilename();
        String newFileName=UUID.randomUUID()+originalFilename;
        File targetFile=new File(filePath,newFileName);
        file.transferTo(targetFile);

        String address=ip+newFileName;
        return address;
    }
}
