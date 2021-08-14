package com.example.lwh4jspringbootstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyStarterProperties.class)
@ConditionalOnClass(MyStarter.class)
@ConditionalOnProperty(prefix = "spring.mystarter", value = "enabled", matchIfMissing = true)
public class MyStarterAutoConfiguration {

    @Autowired
    private  MyStarterProperties myStarterProperties;

    @ConditionalOnMissingBean(MyStarter.class)
    @Bean
    public MyStarter myStarter(){
        MyStarter myStarter = new MyStarter(myStarterProperties);
        return myStarter;
    }

}
