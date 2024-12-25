package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CorsSpringBootStart {
    public static void main(String[] args){
        SpringApplication.run(CorsSpringBootStart.class,args);
        System.out.print("启动完成。。。。。");
    }
}
