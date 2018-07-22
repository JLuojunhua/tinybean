package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.Collection;

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
