package com.example.throwsexception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
/*
* 自定义业务处理异常类
*
* */
/*
* 根据controller的注解类型
* */
//@ControllerAdvice(annotations = RestController.class)
/*
* 根据包名
*
* */
//@ControllerAdvice("com.example.throwsexception")
@ControllerAdvice(assignableTypes = {MyRuntimeExceptionController.class})
public class MyRuntimeExceptionHandler {

    @ResponseBody
    @ExceptionHandler(MyRuntimeException.class)
    public Map<String, String> myRuntimeExceptionHandle(MyRuntimeException myRuntimeException){
        Map<String, String> map = new HashMap<>();
        map.put("code", myRuntimeException.getCode());
        map.put("message", myRuntimeException.getMessage());
        return map;
    }
}
