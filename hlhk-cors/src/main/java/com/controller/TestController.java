package com.controller;

import com.alibaba.fastjson.JSONObject;

import com.config.CryptoUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

//跨域
@RestController
@Slf4j
public class TestController {
    @GetMapping("/cors/test")
    public Object test() {
        return "OK";
    }

    @PostMapping("/cors/logoin")
    public Object logoin(@RequestBody JSONObject jsonpObject) {
        log.info("数据：{}", jsonpObject);
        String passWord = CryptoUtil.decrypt(jsonpObject.getString("passWord"));
        log.info("passWord：{}", passWord);
        return "ok";
    }

}
