package com.myzg.gymnasium.exception;

import org.springframework.objenesis.SpringObjenesis;

public class ProgramException extends RuntimeException{

    private ErrorEnum errorEnum;
    private String detail;

    public ProgramException(ErrorEnum errorEnum) {
        super(errorEnum.getErrorMessage());
        this.errorEnum = errorEnum;
    }

    public ProgramException(ErrorEnum errorEnum, String detail) {
      super((detail == null || detail.equals(""))? errorEnum.getErrorMessage() : detail);
      this.errorEnum = errorEnum;
    }

    public ErrorEnum getErrorEnum() {
        return errorEnum;
    }

    public void setErrorEnum(ErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


}
