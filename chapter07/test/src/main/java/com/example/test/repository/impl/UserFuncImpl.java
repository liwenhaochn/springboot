package com.example.test.repository.impl;

import com.example.test.dao.UserDao;
import com.example.test.entity.User;
import com.example.test.repository.UserFunc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
/*
* 两个注解都可以注入ioc
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
        return userDao.getById(id);
    }

    @Override
    public User getUserByIdAndName(String id, String name) {
        return userDao.getByIdAndName(id, name);
    }

}
