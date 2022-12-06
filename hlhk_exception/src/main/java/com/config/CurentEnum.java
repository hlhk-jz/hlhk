package com.config;

public enum  CurentEnum {
    OK("200","成功"),ERRO("400","失败");
    String code;
    String message;
    CurentEnum(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }
}
