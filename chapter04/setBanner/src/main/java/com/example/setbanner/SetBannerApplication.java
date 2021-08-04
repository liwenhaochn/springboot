package com.example.setbanner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SetBannerApplication {

    public static void main(String[] args) {
        SpringApplication sp = new SpringApplication();
        // yaml配置文件的优先级更高
        sp.setBannerMode(Banner.Mode.OFF);
        sp.run(SetBannerApplication.class, args);
    }

}
