package com.myzg.gymnasium.exceptionadvice;


import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.responsebody.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class AllExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseBody handleException(Exception exception){
        if(exception instanceof ProgramException){
            return ResponseBody.returnResponseBodyByException((ProgramException)exception);
        }
        if(exception instanceof AuthenticationException) {
            return ResponseBody.UNAUTHORIZED();
        }
        if(exception instanceof AccessDeniedException) {
            return ResponseBody.FORBIDDEN();
        }
        if(exception instanceof MethodArgumentNotValidException){
            return ResponseBody.BAD_REQUEST("参数错误请检查");
        }
        log.error(exception.getClass().getName());
        log.error(exception.getMessage());
        return new ResponseBody(-1,"未知错误",null);
    }

}
