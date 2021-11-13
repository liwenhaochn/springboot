package com.example.lwh4jspringbootstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
* 每个starter一般至少要有一个自动配置类
 */
@Configuration
@EnableConfigurationProperties(MyStarterProperties.class)
@ConditionalOnClass(MyStarter.class)
@ConditionalOnProperty(prefix = "spring.mystarter", value = "enabled", matchIfMissing = true)
public class MyStarterAutoConfiguration {

    @Autowired
    private  MyStarterProperties myStarterProperties;

    /*
     * 容器里没有指定bean的情况下自动配置MyStarter类
     */
    @ConditionalOnMissingBean(MyStarter.class)
    @Bean
    public MyStarter myStarter(){
        MyStarter myStarter = new MyStarter(myStarterProperties);
        return myStarter;
    }

}
