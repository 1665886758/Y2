package com.fj.service.impl;

import com.fj.mapper.CommentMapper;
import com.fj.pojo.Comment;
import com.fj.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int deleteCommentInfoById(Integer id) {
        return commentMapper.setDelcommentById(id);
    }

    @Override
    public List<Comment> queryCommentInfo(Integer id) {
        return commentMapper.getsay(id);
    }

    @Override
    public int addCommentInfo(Comment comment) {
        return commentMapper.setInsert(comment);
    }
}
