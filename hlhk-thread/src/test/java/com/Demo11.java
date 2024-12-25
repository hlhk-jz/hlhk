package com;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程，操作共享变量 count 就会引发线程安全问题
 * 数据不正确，A线程改变数据的时候，其它线程也修改了
 */
@Slf4j
public class Demo11 {
    public volatile static int count = 20;
    private  static  AtomicInteger nextSerialNum = new AtomicInteger(20);

    public static void main(String[] args){

        //线程1
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int andDecrement = nextSerialNum.decrementAndGet();
                if(andDecrement > 0){
                    //count--;
                    System.out.println("当前线程："+Thread.currentThread().getName()+"：数量："+andDecrement);
                }else {
                    break;
                }
            }
        }).start();

        //线程2
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int andDecrement = nextSerialNum.decrementAndGet();
                if(andDecrement > 0){
                    //count--;
                    System.out.println("当前线程："+Thread.currentThread().getName()+"：数量："+andDecrement);
                }else {
                    break;
                }
            }
        }).start();

        //线程3
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int andDecrement = nextSerialNum.decrementAndGet();
                if(andDecrement > 0){
                    //count--;
                    System.out.println("当前线程："+Thread.currentThread().getName()+"：数量："+andDecrement);
                }else {
                    break;
                }
            }
        }).start();

    }
}
