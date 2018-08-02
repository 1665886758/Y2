package com.fj.service;

import com.fj.pojo.Detail;
import java.util.List;

public interface DetailService {

    /**
     * 查询主页面信息业务
     */
    public List<Detail> getListAll(String title);

    /**
     *  删除新闻信息业务
     */
    public int deleteById(Integer id);
}
