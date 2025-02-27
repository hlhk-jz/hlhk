package com.config;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//创建线程池，单例
public class ThreadConfig {
    private static ThreadPoolExecutor threadPoolExecutor = null;

    public static ThreadPoolExecutor getThreadPoolExecutor(){
        if(null == threadPoolExecutor){
            synchronized (ThreadConfig.class){
                System.out.println("线程池创建！！！");
                threadPoolExecutor = new ThreadPoolExecutor(3, 6, 200, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
            }
        }
        return threadPoolExecutor;
    }
}
