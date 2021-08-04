package com.example.packagejar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackageJarController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello SpringBoot!";
    }
}
