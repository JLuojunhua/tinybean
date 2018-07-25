package com.qqdzz.tinybean.mapper;


import com.qqdzz.tinybean.dao.CollectionMapper;
import com.qqdzz.tinybean.entity.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CollectionMapperTest {

    @Autowired
    private CollectionMapper collectionMapper;

    @Test
    public void testAdd() {
        Collection collection = new Collection();
        collection.setMovieId(1);
        collection.setUserId(1);
        System.out.println(collectionMapper.add(collection));
    }
}
