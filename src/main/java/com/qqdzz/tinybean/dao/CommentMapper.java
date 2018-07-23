package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CommentMapper {
    void add(Comment collection);
    void delete(Integer id);
    void update(Comment collection);
    Comment findById(Integer id);
}
