package com.example.restful.controller;

import com.example.restful.entity.MyRuntimeException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;


@RestController
public class GlobalExceptionController {

    @RequestMapping("/exception")
    public String test(@RequestParam(value = "i", defaultValue = "0") int i) {
        if (i == 0) {
            throw new MyRuntimeException("600", "自定义业务错误111");
        }
        throw new ValidationException("validate exception");

    }
}
