package com.example.test.service;

import com.example.test.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserInfo() {
        User user = userService.getUserInfo("990001", "liwenhao", 30);
        Assert.assertEquals(user.getId(), "990001");
        Assert.assertEquals(user.getAge(), 30);
        Assert.assertEquals(user.getName(), "liwenhao");
        System.out.println(user.toString());
    }

}