package com.example.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }
   /*
    *
    * add by lwh 20210812 获取的request为空，网上的方法也不可行
    *
    @Bean
    public RequestContextListener requestContextListener(){
        return new RequestContextListener();
    }*/
}
