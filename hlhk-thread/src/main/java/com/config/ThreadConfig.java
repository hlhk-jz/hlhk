package com.config;

import java.util.Hashtable;
import java.util.concurrent.*;

//创建线程池，单例
public class ThreadConfig {
    private static ThreadPoolExecutor threadPoolExecutor = null;

    public static ThreadPoolExecutor getThreadPoolExecutor(){
        if(null == threadPoolExecutor){
            synchronized (ThreadConfig.class){
                System.out.println("线程池创建！！！");
Hashtable h = new Hashtable();
h.get("");
ConcurrentHashMap hashMap = new ConcurrentHashMap();
hashMap.get("");
                threadPoolExecutor = new ThreadPoolExecutor(3, 6, 200, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3));
                //threadPoolExecutor = new ThreadPoolExecutor(3, 6, 200, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
            }
        }
        return threadPoolExecutor;
    }
}
