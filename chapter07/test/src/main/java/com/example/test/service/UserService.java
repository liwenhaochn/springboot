package com.example.test.service;

import com.example.test.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUserInfo(String id, String name, int age) {
        User user = new User();
        user.setId(id);
        user.setAge(age);
        user.setName(name);
        return user;
    }

}
