package com.myzg.gymnasium.responsebody;

import com.myzg.gymnasium.customenum.ResponseEnum;
import com.myzg.gymnasium.exception.ProgramException;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ResponseBody implements Serializable {


    private int code;
    private String status;
    private Object body;

    public ResponseBody() {
    }

    public ResponseBody(int code, String status, Object body) {
        this.code = code;
        this.status = status;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public static ResponseBody returnResponseBodyByException(ProgramException exception){
        if(exception != null){
            return new ResponseBody(exception.getErrorEnum().getReturnCode(),exception.getErrorEnum().getErrorMessage(),null);
        }
        return new ResponseBody(-1,"未知错误",null);
    }

    public static ResponseBody OK(Object result) {
        return  new ResponseBody(ResponseEnum.OK.getCode(), ResponseEnum.OK.getMessage(), result);
    }

    public static ResponseBody INTERNAL_ERROR() {
        return  new ResponseBody(ResponseEnum.INTERNAL_SERVER_ERROR.getCode(), ResponseEnum.INTERNAL_SERVER_ERROR.getMessage(), null);
    }

    public static ResponseBody BAD_REQUEST(String errorMessage) {
        return new ResponseBody(ResponseEnum.BAD_REQUEST.getCode(), ResponseEnum.BAD_REQUEST.getMessage(), errorMessage);
    }

    public static ResponseBody UNAUTHORIZED() {
        return new ResponseBody(HttpStatus.UNAUTHORIZED.value(),"认证失败",null);
    }

    public static ResponseBody FORBIDDEN() {
        return new ResponseBody(HttpStatus.FORBIDDEN.value(), "禁止访问", null);
    }


}
