package com;
import lombok.extern.slf4j.Slf4j;

/**
 * 多线程，操作共享变量 count 就会引发线程安全问题
 * 数据不正确，A线程改变数据的时候，其它线程也修改了
 */
@Slf4j
public class Demo1 {
    public  static int count = 20;
    public static void main(String[] args){
        //线程1
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(count > 0){
                    count--;
                    System.out.println("当前线程："+Thread.currentThread().getName()+"：数量："+count);
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
                if(count > 0){
                    count--;
                    System.out.println("当前线程："+Thread.currentThread().getName()+"：数量："+count);
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
                if(count > 0){
                    count--;
                    System.out.println("当前线程："+Thread.currentThread().getName()+"：数量："+count);
                }
            }
        }).start();

    }
}
