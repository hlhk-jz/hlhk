package com.test;

import com.alibaba.fastjson.JSONObject;
import com.pojo.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * set 和 zset
 */
@RestController
public class RedisSetZsetTs {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //互斥锁
    @GetMapping("/redis/hcs")
    public void hcs(){
        new Thread(()->{
            Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent("CS_KEY", "suo");
            System.out.println("线程1互斥锁返回："+aBoolean);
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            redisTemplate.delete("CS_KEY");
        }).start();
    }

    @GetMapping("/redis/hcs1")
    public void hcs1(){
        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent("CS_KEY", "suo");
        System.out.println("线程222222互斥锁返回："+aBoolean);
        if(aBoolean){
            redisTemplate.delete("CS_KEY");
        }
    }




    @PostMapping("/redis/set")
    public void redisSet(@RequestBody JSONObject jsonObject){
        //1、add：向集合中添加一个或多个元素
        redisTemplate.opsForSet().add(jsonObject.get("key"), jsonObject.get("value1"),jsonObject.get("value2"));
        //2、members：获取集合中的所有成员
        Set members = redisTemplate.opsForSet().members(jsonObject.get("key"));
    }

    @GetMapping("/redis/seta")
    public void redisSeta(){
        Stu stu = new Stu();
        stu.setAge("1");
        stu.setName("张三");
        Stu stu2 = new Stu();
        stu2.setAge("1");
        stu2.setName("张三s");
        redisTemplate.opsForSet().add("redis_set",stu);
        redisTemplate.opsForSet().add("redis_set",stu2);
    }

    @PostMapping("/redis/zset")
    public void redisZSet(@RequestBody JSONObject jsonObject){
        //add：向有序集合中添加一个成员，同时指定该成员的分数
        redisTemplate.opsForZSet().add("myzset", "member1", 0.5);
        redisTemplate.opsForZSet().add("myzset", "member2", 0.8);
        redisTemplate.opsForZSet().add("myzset", "member3", 1.2);

        //range：获取有序集合中指定范围内的成员集合（按分数从低到高排序）
        Set<Object> members = redisTemplate.opsForZSet().range("myzset", 0, -1);

    }
}
