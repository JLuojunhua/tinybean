package com.qqdzz.service;

import com.qqdzz.dao.CommentMapper;
import com.qqdzz.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public boolean doAdd(Comment comment) {
        return true;
    }

    public boolean doModify(Comment comment) {
        return true;
    }

    public boolean doRemove(int id) {
        return true;
    }

    public boolean doRemove(List<Comment> commentList) {
        return true;
    }

    public Comment findById(int id) {
        Comment comment = new Comment();
        return comment;
    }

    public Comment findByUserId(int UserId) {
        Comment comment = new Comment();
        return comment;
    }

    public Comment findByCommentText(String commentText) {
        Comment comment = new Comment();
        return comment;
    }

    public List<Comment> findAll() {
        List<Comment> commentList = new ArrayList<Comment>();
        return commentList;
    }

    public List<Comment> findBannedAll() {
        List<Comment> commentList = new ArrayList<Comment>();
        return commentList;
    }

    public List<Comment> findByCondition(String userName) {
        List<Comment> commentList = new ArrayList<Comment>();
        return commentList;
    }
}
