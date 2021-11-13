package com.example.test.repository;

import com.example.test.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void findUserById(){
        User user = userDao.findUserById("990008");
        System.out.println(user.toString());
    }
    @Test
    public void findUserByIdAndName(){
        User user = userDao.findUserByIdAndName("990008","chenyijun");
        System.out.println(user.toString());
    }
}