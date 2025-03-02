package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EncryStart {
    public static void main(String[] args){
        SpringApplication.run(EncryStart.class,args);
        System.out.println("启动完成。。。。");
    }
}
