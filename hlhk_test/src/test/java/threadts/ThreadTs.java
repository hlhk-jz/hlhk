package threadts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//创建线程池,使用Callable执行结果的线程
public class ThreadTs {
    public static void main(String[] args){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,5 ,
                1000, TimeUnit.MILLISECONDS,  new LinkedBlockingQueue<Runnable>());

        List<Callable<String>> list = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            list.add(
                    new Callable<String>() {
                        @Override
                        public String call() throws Exception {
                            Thread.sleep(5000);
                            System.out.println("线程执行中！！！！");
                            return "abc";
                        }
                    }
            );
        }

        try {
            List<Future<String>> futures = threadPoolExecutor.invokeAll(list);
            for (Future<String> future :futures){
                System.out.print("");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
