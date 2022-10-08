package com;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRedisStart {
    public static void main(String[] args){
        SpringApplication.run(SpringBootRedisStart.class,args);
        System.out.println("启动完成。。。。");
    }
}
