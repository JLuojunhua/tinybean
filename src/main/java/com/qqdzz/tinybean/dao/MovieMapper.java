package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.Movie;
import com.qqdzz.tinybean.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MovieMapper {
    void add(Movie collection);
    void delete(Integer id);
    void update(Movie collection);
    Movie findById(Integer id);
    List<User> findAll();
}
