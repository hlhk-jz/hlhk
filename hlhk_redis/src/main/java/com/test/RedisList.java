package com.test;

import com.pojo.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisList {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/redis/list")
    public void redisList(){
        Stu stu = new Stu();
        stu.setAge("1");
        stu.setName("张三");
        redisTemplate.opsForList().leftPush("redis_list",stu );
        redisTemplate.opsForList().leftPush("redis_list",stu );
        redisTemplate.opsForList().leftPush("redis_list",stu );
    }
}
