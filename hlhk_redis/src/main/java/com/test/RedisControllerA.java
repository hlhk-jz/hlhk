package com.test;

import com.alibaba.fastjson.JSONObject;
import com.pojo.Stu;
import com.util.PojoUtils;
import com.util.RedisVal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@Slf4j
public class RedisControllerA {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/hash")
    public void setHash(@RequestBody JSONObject object){
        String key = object.get("key").toString();
        List<Stu> stus = PojoUtils.getStus();
        Map<String, Object> map = new HashMap<>();
        map.put("stus",stus);
        map.put("time",System.currentTimeMillis());
        //将集合存入hash
        redisTemplate.opsForHash().put(RedisVal.HASH_KEY,key,map);
    }
    @RequestMapping("/getHash")
    public void getHash(@RequestBody JSONObject object){
        String key = object.get("key").toString();
        Object o = redisTemplate.opsForHash().get(RedisVal.HASH_KEY, key);
        if(null != o){
            Map<String, Object> map = (Map<String, Object> )o;
            List<Stu> stus =(List<Stu>)map.get("stus");
            long time = (long)map.get("time");
            log.info("time：{}，list：{}",time,stus);
        }
    }

    @GetMapping("/set/hash")
    public void setHash(){
        String key = "key_";
        for (int i=1;i<4;i++){
            redisTemplate.opsForHash().put(key+i,"a","b");
        }
    }
    @GetMapping("/del/hash")
    public void delHash(){
        String key = "key_";
        key = key+"**";
        Set<String> keys = redisTemplate.keys(key);
        if (!keys.isEmpty()) {
            redisTemplate.delete(keys);
        }
    }

}
