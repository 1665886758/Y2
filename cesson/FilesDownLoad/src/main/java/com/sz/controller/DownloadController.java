package com.sz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/download")
public class DownloadController {

    // 文件下载的根路径
    private String downloadRootPath = "D:" + File.separator;    //File.separator表示 /或\


    @RequestMapping("/m1")
    public String m1(HttpServletResponse response, HttpServletRequest request){
        String remoteHost = request.getRemoteHost();    //request.getRemoteHost()是获得客户端的主机名

        System.out.println("remoteHost:" + remoteHost + "正在下载");


        String fileName = "reposi.rar";
        //1  构建Path对象
        Path path = Paths.get(downloadRootPath +fileName);

        //2 判断这个东西存在与否
        if(Files.exists(path)){
            // 3 判断MIME类型
            String mime = fileName.substring(fileName.lastIndexOf(".") + 1);    //获取后缀 .rar

            // 4 设置MIME类型
            response.setContentType("application/" + mime); //application 表示媒体类型格式

            // 5 添加头信息，指定浏览器执行下载的行为
            String newName = null;
            try {
                newName = new String("一个字就是帅！".getBytes("UTF-8"),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            response.addHeader("Content-Disposition","attachment;filename=" + newName+
                    ".rar");
//            Response.AddHeader("Content-Disposition","attachment;filename=文件名.rar");  下载后的文件名

            // 6 准备写出去（复制）

            // 下载模板页面， 请假单，
            try {
                Files.copy(path,response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "suc";
    }
}
