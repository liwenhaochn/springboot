package com.example.test.service;

import com.example.test.entity.User;

import java.util.List;

/**
 * 该类中的方法不需要遵循jap的命名规范
 */
public interface UserFunc {

    /**
     *
     * @return
     */
    public List<User> getAllUser();

    public User getUserById(String id);

    public User getUserByIdAndName(String id, String name);
}
