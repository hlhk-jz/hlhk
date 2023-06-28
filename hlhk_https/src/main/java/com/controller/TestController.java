package com.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/get/test")
    public Object show(){
        return "成功";
    }

    @PostMapping("/post/test")
    public Object test(@RequestBody Object obg){
        return obg;
    }

    @GetMapping("/get/test/{value}")
    public Object show1(@PathVariable("value") String value){
        return value;
    }
}
