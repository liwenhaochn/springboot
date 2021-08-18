package com.example.test.repository.impl;

import com.example.test.dao.UserDao;
import com.example.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserFuncImpl {
    @Autowired
    private UserDao userDao;

    public List<User> getAllUser() {
        return userDao.findAll();
    }

    public User getUserById(String id) {
        return userDao.getById(id);
    }
}
