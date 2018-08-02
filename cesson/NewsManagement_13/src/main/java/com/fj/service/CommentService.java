package com.fj.service;

import com.fj.pojo.Comment;

import java.util.List;

public interface CommentService {

    /**
     * 删除新闻业务
     * @param id
     * @return
     */
    public int deleteCommentInfoById(Integer id);

    /**
     * 根据新闻Id查询评论
     * @param id
     * @return
     */
    public List<Comment> queryCommentInfo(Integer id);

    /**
     * 新增评论
     * @param comment
     * @return
     */
    public int addCommentInfo(Comment comment);
}
