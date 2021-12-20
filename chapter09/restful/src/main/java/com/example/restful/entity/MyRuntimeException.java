package com.example.restful.entity;
/*
*
*  自定义异常处理类， 从第6章直接拿的代码！
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
