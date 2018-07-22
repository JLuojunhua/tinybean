package com.qqdzz.service;

import com.qqdzz.dao.CollectionMapper;
import com.qqdzz.entity.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
@Service
public class CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    public boolean doAdd(Collection collection){
        return true;
    }

    public boolean doModify(Collection collection){
        return true;
    }

    public boolean doRemove(int id){
        return true;
    }

    public boolean doRemove(List<Collection> collectionList){
        return true;
    }

    public Collection findById(int id){
        Collection collection = new Collection();
        return collection;
    }

    public List<Collection> findAll(){
        List<Collection> collectionList = new ArrayList<Collection>();
        return collectionList;
    }

    public List<Collection> findByCollection(Integer movieId, Integer userId){
        List<Collection> collectionList = new ArrayList<Collection>();
        return collectionList;
    }
}
