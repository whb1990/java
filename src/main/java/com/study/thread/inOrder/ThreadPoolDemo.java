package main.java.com.study.thread.inOrder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: whb
 * @date: 2020/2/21 14:42
 * @description: 线程顺序执行方案四：使用单线程池
 */
public class ThreadPoolDemo {
    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws Exception {

        final Thread thread1 = new Thread(() -> System.out.println("产品经理规划新需求"));

        final Thread thread2 = new Thread(() -> System.out.println("开发人员开发新需求功能"));

        Thread thread3 = new Thread(() -> System.out.println("测试人员测试新功能"));

        System.out.println("早上：");
        System.out.println("产品经理来上班了");
        System.out.println("测试人员来上班了");
        System.out.println("开发人员来上班了");
        System.out.println("领导吩咐:");
        System.out.println("首先，产品经理规划新需求...");
        executorService.submit(thread1);
        System.out.println("然后，开发人员开发新需求功能...");
        executorService.submit(thread2);
        System.out.println("最后，测试人员测试新功能...");
        executorService.submit(thread3);
        executorService.shutdown();
    }
}
