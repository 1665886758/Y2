package com.fj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    private final String UPLOAD_ROOT_PATH="F:"+File.separator+"tempUpload";

    @RequestMapping("/m1")
    public String m1(@RequestParam("username")String username, @RequestParam("file") MultipartFile multipartFile){
//        System.out.println("普通的表单域：" + username);
        //1.处理文件上传
        if(!multipartFile.isEmpty()){
            //2  如果不为空，再上传
            BufferedOutputStream out =  null;
            try {
                // 3 得到字节数据，最终要写出去
                byte[] bytes=multipartFile.getBytes();

                // 4 先看我们目录是否存在，如果不存在创建
                File parent=new File(UPLOAD_ROOT_PATH);
                if(!parent.exists())
                    parent.mkdirs();

                // 5 获取原始文件名
                String originalFilename = multipartFile.getOriginalFilename();

                // 6 我们解析出文件的前缀 aa.txt -->  aa
                String prefix  = originalFilename.substring(0,originalFilename.lastIndexOf("."));

                // 7 解析后缀 aa.doc --> .doc
                String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

                // 8 拼接新的文件名
                String newFileName = prefix + System.currentTimeMillis() + suffix;

                // 9 构建输出文件目的地
                File upFile = new File(UPLOAD_ROOT_PATH + File.separator + newFileName);
                // 10 构建输出对象
                out = new BufferedOutputStream(new FileOutputStream(upFile));

                out.write(bytes);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(out != null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "ok";
    }
}
