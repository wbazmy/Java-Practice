package package1;

import java.util.concurrent.*;

/**
 * @author Zhang Yang
 * @description 线程池测试
 * @date 2021/11/7 - 20:11
 */
public class Threadpooltest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        Printnumber p = new Printnumber(2, pool);
        Future<String> future = pool.submit(p);
        String s = future.get(); //阻塞
        System.out.println(s);
        pool.shutdown();
        int largestpoolsize = ((ThreadPoolExecutor) pool).getLargestPoolSize(); //返回该线程池生命周期中的最大线程数
        System.out.println(largestpoolsize);
    }
}

class Printnumber implements Callable<String> {
    private int num;
    private ExecutorService pool;

    Printnumber(int c, ExecutorService pool1) {
        num = c;
        pool = pool1;
    }

    @Override
    public String call() throws Exception {
        if (num > 0) {
            System.out.println(num);
            Printnumber p = new Printnumber(num - 1, pool);
            Future<String> result = pool.submit(p);
            String s = result.get();
            System.out.println(s);
            return "successful";
        } else return "false";

    }
}