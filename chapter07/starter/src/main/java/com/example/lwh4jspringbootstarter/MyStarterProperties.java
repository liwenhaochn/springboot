package com.example.lwh4jspringbootstarter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/*
* 自定义Properties类
*
* */
@Setter
@Getter
@ConfigurationProperties(prefix = "spring.mystarter")
public class MyStarterProperties {
    private String parameter;
}
