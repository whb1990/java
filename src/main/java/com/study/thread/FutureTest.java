package main.java.com.study.thread;

import java.util.concurrent.*;

/**
 * @author: whb
 * @date: 2019/8/13 14:28
 * @description: FutureTask测试
 */
public class FutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Callable task = () -> {
            return "结果";
        };
        FutureTask ft = new FutureTask(task);
        executor.submit(ft);
        System.out.println(ft.get());

        Future result1 = executor.submit(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            return sum;
        });
        Future result2 = executor.submit(() -> {
            int sum = 0;
            for (int i = 10; i < 100; i++) {
                sum += i;
            }
            return sum;
        });
        executor.shutdown();
        System.out.println(result1.get() + "  " + result2.get());
    }
}
