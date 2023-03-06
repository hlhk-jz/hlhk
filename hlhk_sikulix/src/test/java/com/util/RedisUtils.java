package com.util;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisUtils {
    public static StringRedisTemplate redisTemplate = new StringRedisTemplate();
    static {
        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration();
        rsc.setPort(6379);
        rsc.setHostName("localhost");
        RedisConnectionFactory fac = new JedisConnectionFactory(rsc);
        redisTemplate.setConnectionFactory(fac);
        redisTemplate.afterPropertiesSet();
    }

 /*   public static void main(String[] args){
      System.out.println(RedisUtils.redisTemplate.opsForValue().get("isTrue"));
    }*/
}
