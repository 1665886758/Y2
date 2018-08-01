package com.fj.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Entry implements Serializable {

    /**
     * 在代码运行的时候，我们可以看到很多的对象(debug过的都造吧)，
     * 可以是一个，也可以是一类对象的集合，很多的对象数据，这些数据中，
     * 有些信息我们想让他持久的保存起来，那么这个序列化。
     * 就是把内存里面的这些对象给变成一连串的字节描述的过程。
     * 常见的就是变成文件
     */
    /*
    什么情况下需要序列化
        当你想把的内存中的对象状态保存到一个文件中或者数据库中时候；
        当你想用套接字在网络上传送对象的时候；
        当你想通过RMI传输对象的时候；
     */
    private static final long serialVersionUID = 3741358553926792249L;

    private int id; //序号

    private int categoryId; //分类编号

    private String title;   //文档名称

    private String summary; //摘要

    private String uploaduser;  //上传人

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    private String createdate;    //创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUploaduser() {
        return uploaduser;
    }

    public void setUploaduser(String uploaduser) {
        this.uploaduser = uploaduser;
    }


}
