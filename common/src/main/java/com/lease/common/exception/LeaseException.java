package com.lease.common.exception;


import com.lease.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author yff
 * @date 2026-01-26 11:15:01
 */
@Data
public class LeaseException extends RuntimeException{

    private Integer code;

    public LeaseException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public LeaseException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }


}

