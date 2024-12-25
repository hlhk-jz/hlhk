package com;

public class Demo3 {
    public static volatile boolean isTrue = true;
   public static void main(String[] args){
       new Thread(()->{
           while (isTrue){

           }
           System.out.println("执行结束");
       }).start();
       new Thread(()->{
           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           isTrue = false;
           System.out.println("线程2执行结束");
       }).start();
   }
}
