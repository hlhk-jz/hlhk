package com.util;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;
public class RedisUtils {
    public static StringRedisTemplate redisTemplate = new StringRedisTemplate();
    static {
        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration();
        rsc.setPort(6379);
        rsc.setHostName("localhost");
       /* JedisPoolConfig poolConfig = jedisPoolConfig();
        JedisClientConfiguration jedisPoolConfig = JedisClientConfiguration.builder()
                .usePooling().poolConfig(poolConfig).build();*/
        //RedisConnectionFactory fac = new JedisConnectionFactory(rsc,jedisPoolConfig);
        RedisConnectionFactory fac = new JedisConnectionFactory(rsc);
        redisTemplate.setConnectionFactory(fac);
       // redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.afterPropertiesSet();
    }
    //https://www.cnblogs.com/jpfss/p/11265036.html 连接参数详解
 /*   public static JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //连接池中的最大空闲连接
        poolConfig.setMaxIdle(8);
        //连接池最大连接数（使用负值表示没有限制）
        poolConfig.setMaxTotal(8);
        //连接池最大阻塞等待时间（使用负值表示没有限制）
        poolConfig.setMaxWaitMillis(-1);
        //当从连接池中取出一个连接时是否进行验证，若验证失败则从池中删除该连接并尝试取出另一个连接
        poolConfig.setTestOnBorrow(true);
        //对池中空闲的连接是否进行验证，验证失败则回收此连接
        poolConfig.setTestWhileIdle(true);
        //testOnCreate 连接在创建之后是否进行验证 false
        poolConfig.setTestOnCreate(false);
        //当一个连接使用完归还到连接池时是否进行验证
        poolConfig.setTestOnReturn(false);
        return poolConfig;
    }*/
}
