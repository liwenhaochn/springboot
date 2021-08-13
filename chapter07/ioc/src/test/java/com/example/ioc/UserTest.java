package com.example.ioc;

import com.example.ioc.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/*
* 感觉这个注解没啥用
*
* */
@RunWith(SpringRunner.class)
/*
* 测试入口类
* */
@SpringBootTest
public class UserTest {
    /*通过上下文获取bean*/
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test(){
        User user = (User) applicationContext.getBean("myuser");
        System.out.println(user);
    }
}
