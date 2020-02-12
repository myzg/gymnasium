package com.myzg.gymnasium.customenum;

public enum ResponseEnum {
    BAD_REQUEST(400,"请求出错"),
    OK(200,"成功"),
    INTERNAL_SERVER_ERROR(500,"服务器内部错误"),
    DATA_NOT_FOUND(459,"数据不存在");


    private int code;
    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
