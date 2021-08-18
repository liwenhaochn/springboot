package com.example.test.repository.impl;

import com.example.test.dao.UserDao;
import com.example.test.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
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
}