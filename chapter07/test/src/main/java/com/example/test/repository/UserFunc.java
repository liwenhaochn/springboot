package com.example.test.repository;

import com.example.test.entity.User;

import java.util.List;

public interface UserFunc {

    public List<User> getAllUser();

    public User getUserById(String id);

    public User getUserByIdAndName(String id, String name);
}
