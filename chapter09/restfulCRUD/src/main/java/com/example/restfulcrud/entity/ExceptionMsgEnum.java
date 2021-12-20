package com.example.restfulcrud.entity;

public enum ExceptionMsgEnum {

    SUCESS("200", "操作成功"),
    FAIL("999", "操作失败");

    private String code;
    private String msg;

    ExceptionMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ExceptionMsgEnum{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
