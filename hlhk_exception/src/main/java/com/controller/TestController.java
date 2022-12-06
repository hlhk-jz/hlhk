package com.controller;

import com.command.TestCommand;
import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestService testService;
    @PostMapping("/test")
    public Object test(@Validated @RequestBody TestCommand command){
        System.out.println(""+command);
        return testService.selectPojo();
    }
}
