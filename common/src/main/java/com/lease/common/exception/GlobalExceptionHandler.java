package com.lease.common.exception;


import com.lease.common.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yff
 * @date 2026-01-23 13:25:14
 */

//该类为全局异常处理器  专门捕获Controller层的异常处理

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//捕获所有异常
    @ResponseBody
    public Result handle(Exception e){
        e.printStackTrace();//打印异常信息
        return Result.fail();
    }


}
