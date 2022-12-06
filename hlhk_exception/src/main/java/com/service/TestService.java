package com.service;

import com.config.CurentEnum;
import com.config.CurentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestService {
    public Object selectPojo(){
        try {
            Object x = new Integer(0);
            System.out.println((String)x);
        }catch (Exception e){
            //throw new CurentException("121","自定义异常" );
            throw new CurentException(CurentEnum.ERRO);
        }
        return "ok";
    }
}
