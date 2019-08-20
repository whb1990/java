package main.java.com.study.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: whb
 * @date: 2019/8/20 14:19
 * @description: 增强版Future测试类
 */
public class CompletableFutureTest implements Runnable {

    CompletableFuture<Integer> completableFuture = null;

    public CompletableFutureTest(CompletableFuture<Integer> completableFuture) {
        this.completableFuture = completableFuture;
    }

    @Override
    public void run() {
        int result = 0;
        try {
            result = completableFuture.get() * completableFuture.get();
        } catch (Exception e) {

        }
        System.out.println(result);
    }

    public static Integer calc(Integer param) {
        try {
            //模拟长时间的执行
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        return param * param;
    }

    public static Integer calc2(Integer param) {
        return param / 2;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(new CompletableFutureTest(future)).start();
        //模拟长时间的计算过程
        Thread.sleep(1000);
        //告知完成结果
        future.complete(60);

        //异步调用
        final CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> calc(50));
        System.out.println(future2.get());

        //流式调用
        CompletableFuture<Void> future3 = CompletableFuture.supplyAsync(() -> calc(40))
                .thenApply((i) -> Integer.toString(i))
                .thenApply((str) -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        future3.get();

        //组合多个CompletableFuture
        CompletableFuture<Void> future4 = CompletableFuture.supplyAsync(() -> calc2(100))
                .thenCompose((i) -> CompletableFuture.supplyAsync(() -> calc2(i)))
                .thenApply((str) -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        future4.get();
    }
}
