package com;
import org.python.antlr.ast.Print;
import org.sikuli.script.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadTest {

 /*   public static void main(String[] args){
        List<String> targets = new ArrayList<>();
        long start = System.currentTimeMillis();
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        List<String> str = getList();
        for (String s : str){
            try {
                Match match = region.wait(s,0.5);
                if(null != match){
                    targets.add(s);
                }
            } catch (FindFailed findFailed) {
                findFailed.printStackTrace();
            }
        }
        for (String sd : targets){
            System.out.println(sd);
        }
        long end = System.currentTimeMillis();
        System.out.println("执行完成~~~~~"+(end - start));
    }*/

    //多线程
 /*  public static void main(String[] args)throws Exception{
       long start = System.currentTimeMillis();
       ThreadPoolExecutor executor = ThreadPoolUtils.getThreadPool();
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);

        List<Callable<String>> list = new ArrayList<>();
        Callable<String> callable = null;
        for(String str : getList()){
            callable = new Callable() {
                @Override
                public String call() throws Exception {
                    synchronized (Object.class){
                        Match match = region.wait(str, 0.5);
                        if(null != match){
                            return str;
                        }
                        return "";
                    }
                }
            };
            list.add(callable);
        }

        List<Future<String>> futures = executor.invokeAll(list);
        if(null != futures && !futures.isEmpty()){
            for (Future<String> future : futures){
                String str = future.get();
                System.out.println(str);
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("执行完成~~~~~"+(end - start));
        executor.shutdown();
    }*/

 /* public static void main(String[] args)throws Exception{
      long start = System.currentTimeMillis();
      Region region = new Region(0, 0,1920,1080);
      region.setThrowException(false);
      List<String> list = getList();
      for (String str : list){
          Match wait = region.wait(str, 5);
          wait.hover();
      }
      long end = System.currentTimeMillis();
      System.out.println("执行完成~~~~~"+(start-end));
  }*/

/* public static void main(String[] args){
     long start = System.currentTimeMillis();
     Region region = new Region(0, 0,1920,1080);
     region.setThrowException(false);
     ThreadPoolExecutor threadPool = ThreadPoolUtils.getThreadPool();
     List<String> list = getList();
     List<String> targets = new ArrayList<>();
     for (String str : list){
         threadPool.submit(()->{
             try {
                 synchronized (Object.class){
                     Match match = region.wait(str, 1);
                     if(null != match){
                         System.out.println(str);
                         targets.add(str);
                     }
                 }
             } catch (FindFailed findFailed) {
                 findFailed.printStackTrace();
             }
         });
     }
     threadPool.shutdown();
     System.out.println(targets.size());
 }*/


    public static List<String> getList(){
        List<String> list = new ArrayList<>();
        list.add("D:/sikuliximage/file2/a.png");
        list.add("D:/sikuliximage/file2/b.png");
        list.add("D:/sikuliximage/file2/c.png");
        list.add("D:/sikuliximage/file2/d.png");
        list.add("D:/sikuliximage/file2/e.png");
        list.add("D:/sikuliximage/file2/f.png");
        list.add("D:/sikuliximage/file2/g.png");
        return list;
    }
}
