package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface CollectionMapper {

    void add(Collection collection);
    void delete(Integer id);
    void update(Collection collection);
    Collection findById(Integer id);
}
