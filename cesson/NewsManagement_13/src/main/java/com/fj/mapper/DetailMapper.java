package com.fj.mapper;

import com.fj.pojo.Detail;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface DetailMapper {

    /**
     * 查询主页面信息
     */
    public List<Detail> listAll(@Param("title") String title);

    /**
     * 2.评论删掉后删除新闻信息
     */
    public int setDeleteInfo(@Param("id")Integer id);
}
