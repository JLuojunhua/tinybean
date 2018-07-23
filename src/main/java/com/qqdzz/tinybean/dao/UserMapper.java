package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    void add(User collection);
    void delete(Integer id);
    void update(User collection);
    User findById(Integer id);
    List<User> findAll();
}
