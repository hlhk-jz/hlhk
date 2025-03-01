package com;

import java.util.HashMap;
import java.util.Hashtable;

public class Demo111 {
    public static Object object = new Object();
    public static Object object2 = new Object();
    public static void main(String[] args){
        /*HashMap<String,String> map = new HashMap<>();
        map.put(null,null );
        System.out.println(map);*/

        Thread thread = new Thread(){
            @Override
            public void run(){
                synchronized (object){
                    try {
                        object2.wait();
                        Thread.sleep(4000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("1111111111执行！！！");
                }
            }
        };
        thread.start();


        Thread thread2 = new Thread(){
            @Override
            public void run(){
                synchronized (object){
                  /*  try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    System.out.println("222222执行！！！");
                    object2.notifyAll();
                }
            }
        };
        thread2.start();

    }
}
