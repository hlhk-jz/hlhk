package com;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 和 synchronized差不多，比synchronized更灵活
 * ReentrantLock 是显示锁可以设置公平非公平锁
 */
public class Demo4 {
    private ReentrantLock lock = new ReentrantLock();
    private double balance;

    public Demo4(double initialBalance) {
        balance = initialBalance;
    }

    // 存款
    public void deposit(double amount) {
        lock.lock(); // 获取锁
        try {
            balance += amount; // 更新余额
            System.out.println("存款成功，当前余额为：" + balance);
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    // 取款
    public void withdraw(double amount) {
        lock.lock(); // 获取锁
        try {
            if (balance >= amount) {
                balance -= amount; // 更新余额
                System.out.println("取款成功，当前余额为：" + balance);
            } else {
                System.out.println("余额不足");
            }
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    public static void main(String[] args) {
        Demo4 account = new Demo4(1000.0);

        // 创建两个线程模拟两个用户进行存款和取款操作
        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(100.0);
            }
        });

        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(200.0);
            }
        });
        depositThread.start();
        withdrawThread.start();
    }
}