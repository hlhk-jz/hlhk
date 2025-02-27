package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//事务
@RestController
public class RedisAffairs {
    @Autowired
    private RedisTemplate redisTemplate;

    //这个没加事务就会a1存了，a2没有存
    @GetMapping("/redis/aff")
    public void redisAff(){
        redisTemplate.opsForValue().set("a1","a1" );
        int i = 1/0;
        redisTemplate.opsForValue().set("a2","a2" );
    }

    @GetMapping("/redis/aff1")
    public void redisAff1(){
        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                //开启事务
                redisOperations.multi();
                redisTemplate.opsForValue().set("a1","a1" );
                int i = 1/0;
                redisTemplate.opsForValue().set("a2","a2" );
                //提交事务
                return redisOperations.exec();
            }
        });
    }
}
