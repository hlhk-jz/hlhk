package com.controller;

import com.config.ThreadConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicBoolean;

//自旋锁
@RestController
public class SpinController {
    public static AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    public static int count = 0;

    @GetMapping("/spin")
    public void spinShow(){
        count = 0;
        for (int i = 0;i<20;i++){
            ThreadConfig.getThreadPoolExecutor().submit(()->{
                lock();
                System.out.println("======"+Thread.currentThread().getName()+"="+count);
                count++;
                unlock();
            });
        }
    }

    public void lock(){
        while (!atomicBoolean.compareAndSet(false,true )){
            //自旋
        }
    }

    public void unlock(){
        atomicBoolean.compareAndSet(true,false );
    }
}
