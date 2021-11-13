package com.example.test.service.impl;

import com.example.test.repository.UserDao;
import com.example.test.entity.User;
import com.example.test.service.impl.UserFuncImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
/*
* 添加事务注解会回滚，不会插入数据，该注解可以加到方法上
* */
//@Transactional
/*
* rollback控制是否回归
* */
@Rollback(false)
public class UserFuncImplTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserFuncImpl userFuncImpl;


    @Test
    public void userFuncTest(){
        System.out.println(userFuncImpl.getAllUser());
        System.out.println(userFuncImpl.getUserByIdAndName("990007", "liwenhao"));
        System.out.println(userFuncImpl.getUserById("990008"));
    }

    @Test
    public void getAllUserTest() {
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void WriteTest() {
        ArrayList<User> userList = new ArrayList<>();
        User user = new User();
        user.setId("990007");
        user.setName("liwenhao");
        user.setAge(30);
        userList.add(user);

        User user1 = new User();
        user1.setId("990008");
        user1.setName("chenyijun");
        user1.setAge(26);

        userList.add(user1);

        userDao.saveAll(userList);
    }

    @Test
    public void getUserByIdNameTest(){
        User user = userDao.findUserByIdAndName("990007", "liwenhao");
        System.out.println(user.toString());
    }
}