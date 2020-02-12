package com.myzg.gymnasium.exception;

public enum ErrorEnum {
    ILLEGAL_ARGS("ILLEGAL_ARGS","非法参数",400),
    SQL_FAILURE("SQL_FAILURE","数据处理失败",500),
    ALIPAY_CLIENT_ERROR("ALIPAY_CLIENT_ERROR","阿里支付客户端初始化失败",-1);

    private String errorCode;
    private String errorMessage;
    private int returnCode;


    ErrorEnum(String errorCode, String errorMessage,int returnCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.returnCode = returnCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }
}
