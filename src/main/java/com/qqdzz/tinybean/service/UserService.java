package com.qqdzz.tinybean.service;

import com.qqdzz.tinybean.dao.UserMapper;
import com.qqdzz.tinybean.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean doAdd(User user){
        return true;
    }

    public boolean doModify(User user){
        return true;
    }

    public boolean doModifyIcon(String icon){
        return true;
    }

    public boolean doRemove(int id){
        return true;
    }

    public boolean doRemove(List<User> userList){
        return true;
    }

    public User findById(int id){
        User user = new User();
        return user;
    }

    public User findByUserName(String userName){
        User user = new User();
        return user;
    }

    public List<User> findAll(){
        List<User> userList = new ArrayList<User>();
        return userList;
    }

    public List<User> findByCondition(String userName){
        List<User> userList = new ArrayList<User>();
        return userList;
    }
}
