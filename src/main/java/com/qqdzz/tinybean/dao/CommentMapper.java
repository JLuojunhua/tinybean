package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CommentMapper {
    int add(Comment collection);
    int delete(Integer id);
    int update(Comment collection);
    Comment findById(Integer id);
    //List<Comment> findByUserId(Integer userId)
    //List<Comment> findByCommentText(String commentText)
    //List<Comment> findBannedAll()
    //List<Comment> findByMovieName()
}
