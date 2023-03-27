package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDkStart {
    public static void main(String[] args){
        SpringApplication.run(SpringBootDkStart.class,args);
        System.out.println("启动完成。。。。");
    }
}
