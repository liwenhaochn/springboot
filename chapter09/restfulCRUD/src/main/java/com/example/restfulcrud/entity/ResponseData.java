package com.example.restfulcrud.entity;

public class ResponseData extends Response {
    private Object data;

    public ResponseData(Object data) {
        this.data = data;
    }

    public ResponseData(ExceptionMsgEnum exceptionMsgEnum, Object data) {
        super(exceptionMsgEnum);
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "data=" + data +
                '}' + super.toString();
    }

    /**
     * add by lwh 20211220 这2个静态方法qque     *
     *
     * @return
     */
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
