package com.qqdzz.dao;

import com.qqdzz.entity.Collection;

import java.util.List;

public interface CollectionMapper {

    /**
     * delete collection by primary key
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert a collection record
     * @param record
     * @return
     */
    int insert(Collection record);

    /**
     * insertSelective?
     * @param record
     * @return
     */
    int insertSelective(Collection record);

}
