package com.config;

import lombok.Data;

/**自定义异常需要继承该类*/
@Data
public class CurentException extends RuntimeException {
    private String code;
    private String message;
    public CurentException(String code,String message){
        this.message = message;
        this.code = code;
    }

    public CurentException(CurentEnum curentEnum){
        this.code = curentEnum.getCode();
        this.message = curentEnum.getMessage();
    }
}
