package com.example.filterandlistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class FilterAndListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterAndListenerApplication.class, args);
    }

}
