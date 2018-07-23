package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.Score;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ScoreMapper {
    void add(Score collection);//返回插入行数
    void delete(Integer id);
    void update(Score collection);//返回修改行数
    Score findById(Integer id);
}
