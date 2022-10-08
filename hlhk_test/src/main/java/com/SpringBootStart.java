package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringBootStart {
    public static void main(String[] args){
        SpringApplication.run(SpringBootStart.class,args);
        System.out.print("启动完成。。。。");
            }
        }
