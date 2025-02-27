package com.controller;
import com.config.ThreadConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class TestController {

    @GetMapping("/thread/zx")
    public void test(){
        for (int i = 0;i<5;i++){
            ThreadConfig.getThreadPoolExecutor().submit(()->{
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+ System.currentTimeMillis());
            });
        }
    }
}
