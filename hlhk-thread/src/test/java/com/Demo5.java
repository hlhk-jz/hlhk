package com;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo5 {
    private static ReentrantLock fairLock = new ReentrantLock(true);  // 创建公平锁
    private static ReentrantLock nonFairLock = new ReentrantLock(false);  // 创建非公平锁

    public static void main(String[] args) {
        // 公平锁示例
        Thread fairThread1 = new Thread(() -> {
            fairLock.lock();  // 获取公平锁
            try {
                System.out.println("公平锁 - 线程1获取到锁");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                fairLock.unlock();  // 释放公平锁
                System.out.println("公平锁 - 线程1 释放公平锁");
            }
        });

        Thread fairThread2 = new Thread(() -> {
            fairLock.lock();  // 获取公平锁
            try {
                System.out.println("公平锁 - 线程2获取到锁");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                fairLock.unlock();  // 释放公平锁
                System.out.println("公平锁 - 线程2 释放公平锁");
            }
        });

        // 非公平锁示例
        Thread nonFairThread1 = new Thread(() -> {
            nonFairLock.lock();  // 获取非公平锁
            try {
                System.out.println("非公平锁 - 线程1获取到锁");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                nonFairLock.unlock();  // 释放非公平锁
                System.out.println("非公平锁 - 线程1 释放非公平锁");
            }
        });

        Thread nonFairThread2 = new Thread(() -> {
            nonFairLock.lock();  // 获取非公平锁
            try {
                System.out.println("非公平锁 - 线程2获取到锁");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                nonFairLock.unlock();  // 释放非公平锁
                System.out.println("非公平锁 - 线程2 释放非公平锁");
            }
        });

        fairThread1.start();
        fairThread2.start();
        nonFairThread1.start();
        nonFairThread2.start();
    }
}