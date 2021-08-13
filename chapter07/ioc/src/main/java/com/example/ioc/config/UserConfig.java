package com.example.ioc.config;

import com.example.ioc.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
*
* 通过@Configuration注解，使该类为配置注解类，产生一个Bean并交给Spring管理
*
* */
@Configuration
public class UserConfig {

    @Bean("myuser")
    public User user(){
        User user = new User();
        user.setId(990001);
        user.setName("liwenhao");
        return user;
    }
}