package com.fj.mapper;

import com.fj.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    /**
     * 1.删除新闻首先删掉该新闻的评论
     * @param id
     * @return
     */
    public int setDelcommentById(@Param("newid") Integer id);


    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    public List<Comment> getsay(@Param("newid")Integer id);

    /**
     * 评论
     */
    public int setInsert(Comment comment);
}
