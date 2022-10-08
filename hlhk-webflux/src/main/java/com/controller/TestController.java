package com.controller;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;


@RestController
public class TestController {

    @GetMapping("/flux/test")
    public Mono<String> getId(){
        return Mono.just("123");
    }

    @GetMapping("/flux/user")
    public Mono<User>  getUser(){
        return Mono.just(new User("张三","33","1"));
    }

}
