package com.example.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {

    @GetMapping("/aop")
    public String aop(){
        System.out.println("aop!");
        return "hello aop!";
    }
}
