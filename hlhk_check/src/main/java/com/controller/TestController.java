package com.controller;

import com.command.TestCommand;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("/test1")
    public Object test1(@Validated @RequestBody TestCommand command){

        return "OK";
    }
}
