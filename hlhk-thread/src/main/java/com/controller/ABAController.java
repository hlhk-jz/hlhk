package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**解决ABA问题*/
@RestController
public class ABAController {
    AtomicMarkableReference<Integer> atomicMarkableReference = new AtomicMarkableReference<>(0,false );

    @GetMapping("/aba/test")
    public void abaShow(){
        new Thread(()->{
            // 获取当前标记
            boolean[] markHolder = new boolean[1];
            //获取当前值，此时是 0 初始值
            Integer value = atomicMarkableReference.get(markHolder);
            //模拟耗时操作
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           //修改值
            boolean b = atomicMarkableReference.compareAndSet(value, 3, markHolder[0], true);
            if(b){
                System.out.println("线程1修改成功");
            }else {
                System.out.println("线程1修改失败");
            }
        }).start();

        new Thread(()->{
            // 获取当前标记
            boolean[] markHolder = new boolean[1];
            //获取当前值，此时是 0 初始值
            Integer value = atomicMarkableReference.get(markHolder);
            //修改值
            boolean b = atomicMarkableReference.compareAndSet(value, 0, markHolder[0], true);
            if(b){
                System.out.println("线程2修改成功");
            }
        }).start();
    }
}
