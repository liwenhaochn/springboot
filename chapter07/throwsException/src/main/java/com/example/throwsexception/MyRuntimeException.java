package com.example.throwsexception;
/*
*
* 自定义异常处理类
*
* */
public class MyRuntimeException extends RuntimeException{

    private String code;

    public MyRuntimeException(String code, String msg){
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
