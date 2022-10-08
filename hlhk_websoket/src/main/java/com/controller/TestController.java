package com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
public class TestController {
    @GetMapping("/test/{userId}")
    public Object show(@PathVariable("userId") String userId){
        try {
            WebSocketServer.sendInfo("推送！！！！！！！！！！",userId);
        } catch (IOException e) {
            log.error("当前用户不在线！！！！！！！！！！！！");
        }
        return "sucess";
    }
}
