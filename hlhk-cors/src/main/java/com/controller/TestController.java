package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//跨域
@RestController
public class TestController {
    @GetMapping("/cors/test")
    public Object test(){
        return "OK";
    }
}
