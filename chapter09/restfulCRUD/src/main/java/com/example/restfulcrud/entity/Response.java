package com.example.restfulcrud.entity;

public class Response {
    private String code = "300";
    private String msg = "操作成功啦";

    public Response() {
    }

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(ExceptionMsgEnum msgEnum) {
        this.code = msgEnum.getCode();
        this.msg = msgEnum.getMsg();
    }

    @Override
    public String toString() {
        return "Response{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
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
}
