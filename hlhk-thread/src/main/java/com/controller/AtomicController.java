package com.controller;
import com.config.ThreadConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;

//使用原子类
@RestController
public class AtomicController {
    AtomicInteger integer = new AtomicInteger(0);
    // int is = 0;
    //测试AtomicInteger
    @GetMapping("/int")
    public void atomicIntegerMethod(){
        ThreadPoolExecutor threadPoolExecutor = ThreadConfig.getThreadPoolExecutor();
        for (int i=0;i<10;i++){
            Thread thread = new Thread(() -> {
                //addAndGet增加指定值并返回新值
                int it = integer.addAndGet(1);
                //如果不使用原子类，这块的is++就需要加同步锁否则就会引发线程安全
                //is++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(it);
            });
            threadPoolExecutor.submit(thread);
        }
    }
}
