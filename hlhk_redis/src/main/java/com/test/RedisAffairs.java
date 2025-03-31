package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
                redisOperations.discard();
                //通常watch在multi之前
                redisOperations.watch("a1");
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

    @GetMapping("/redis/aff3/{key}")
    public Object aff3(@PathVariable("key") String key){
        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                //监听key
                redisTemplate.watch(key);
                //开启事务
                redisTemplate.multi();
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                redisTemplate.opsForValue().set(key,key+key );
                return redisOperations.exec();
            }
        });
        return redisTemplate.opsForValue().get(key);
    }

    @GetMapping("/redis/aff2/{key}")
    public Object aff2(@PathVariable("key") String key){
        redisTemplate.opsForValue().set(key, UUID.randomUUID().toString() );
        return redisTemplate.opsForValue().get(key);
    }

    @GetMapping("/redis/absent/{key}")
    public Object absent(@PathVariable("key") String key){
        Boolean aTrue = redisTemplate.opsForValue().setIfAbsent(key, "true");
        if(aTrue){
            Boolean expire = redisTemplate.expire(key, 10000, TimeUnit.MICROSECONDS);

        }

        redisTemplate.opsForValue().set(key, UUID.randomUUID().toString() );
        return redisTemplate.opsForValue().get(key);
    }
}
