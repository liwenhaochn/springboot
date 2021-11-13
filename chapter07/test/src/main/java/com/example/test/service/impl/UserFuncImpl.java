package com.example.test.service.impl;

import com.example.test.repository.UserDao;
import com.example.test.entity.User;
import com.example.test.service.UserFunc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
* 两个注解都可以注入ioc
* add by lwh 20211113 这里得注入到IOC
*
* */
@Service
//@Component
public class UserFuncImpl implements UserFunc {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public User getUserByIdAndName(String id, String name) {
        return userDao.findUserByIdAndName(id, name);
    }

}
