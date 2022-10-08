package com;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class FileStart {
    public static void main(String[] args){
        SpringApplication.run(FileStart.class,args);
        System.out.println("启动完成。。。");
    }
}
