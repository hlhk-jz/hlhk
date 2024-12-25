package com;

public class Demo2 implements Runnable {
    private volatile boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入run了");
        while (isRunning) {

        }
        System.out.println("线程被停止了！");
    }

    public static void main(String[] args) throws InterruptedException {
        Demo2 thread = new Demo2();
        new Thread(thread).start();
        Thread.sleep(100);
        thread.setRunning(false);
        System.out.println("已经赋值为false");
    }
}