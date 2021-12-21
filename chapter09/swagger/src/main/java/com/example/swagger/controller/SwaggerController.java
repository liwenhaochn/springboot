package com.example.swagger.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

    @ApiOperation(value = "hello", notes = "not parameters")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() throws Exception {
        return "hello, Swagger2!";
    }
}
