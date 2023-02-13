package com;
import org.sikuli.script.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadTest {

    //多线程
  /* public static void main(String[] args)throws Exception{
       long start = System.currentTimeMillis();
       ThreadPoolExecutor executor = ThreadPoolUtils.getThreadPool();
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);

        List<Callable<Match>> list = new ArrayList<>();
        Callable<Match> callable = null;
        for(String str : getList()){
            callable = new Callable() {
                @Override
                public Match call() throws Exception {
                    return region.wait(str,5 );
                }
            };
            list.add(callable);
        }

        List<Future<Match>> futures = executor.invokeAll(list);
        if(null != futures && !futures.isEmpty()){
            for (Future<Match> future : futures){
                Match match = future.get();
                if(null != match){
                    match.hover();
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("执行完成~~~~~"+(start-end));
        executor.shutdown();
    }*/

  public static void main(String[] args)throws Exception{
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
  }


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
