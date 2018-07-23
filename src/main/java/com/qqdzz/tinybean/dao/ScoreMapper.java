package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.Score;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ScoreMapper {
    void add(Score collection);
    void delete(Integer id);
    void update(Score collection);
    Score findById(Integer id);
}
