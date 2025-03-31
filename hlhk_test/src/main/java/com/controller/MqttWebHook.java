package com.controller;

import cn.hutool.core.lang.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class MqttWebHook {
    @PostMapping("/webhook")
    public String webhook(@RequestBody  Map<Object,Object> payload) {
        log.info("======={}",payload);
        return "Received";
    }
}
