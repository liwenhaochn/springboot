package com.example.throwsexception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRuntimeExceptionController {
    @RequestMapping("/myruntimeexception")
    public String hello(@RequestParam("i") int i){
        if(i==0){
            throw new MyRuntimeException("600", "600 runtimeException!");
        }else {
            return "success";
        }
    }
}
