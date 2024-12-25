package com;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 */
public class Demo6 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            boolean flag = true;
            Thread.currentThread().setName("线程A");
            try {
                System.out.println(Thread.currentThread().getName()+"开始执行");
                flag =  lock.tryLock(5, TimeUnit.SECONDS);
                if(flag){
                    Thread.currentThread().sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"获取到锁");
                }else{
                    System.out.println(Thread.currentThread().getName()+"未获取到锁");
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(flag){
                    lock.unlock();
                }
            }

        }).start();

        new Thread(() -> {
            boolean flag = false;
            Thread.currentThread().setName("线程B");
            try {
                System.out.println(Thread.currentThread().getName()+"开始执行");
                //lock.tryLock();
                flag =  lock.tryLock(3, TimeUnit.SECONDS);
                if(flag){
                    Thread.currentThread().sleep(5000);
                    System.out.println(Thread.currentThread().getName()+"获取到锁");
                }else{
                    System.out.println(Thread.currentThread().getName()+"未获取到锁");
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(flag) {
                    lock.unlock();
                }
            }

        }).start();

    }
}

