package main.java.com.study.lock.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author: whb
 * @date: 2019/8/26 17:16
 * @description: A线程需要用到B线程，C线程，D线程的结果，通过CountDownLatch实现
 */
public class CountDownLatchTest {
    private static int totalCount;
    private static int count1;
    private static int count2;
    private static int count3;
    private static CountDownLatch cdl = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            count1 = 10;
            cdl.countDown();
        }).start();
        new Thread(() -> {
            count2 = 20;
            cdl.countDown();
        }).start();
        new Thread(() -> {
            count3 = 30;
            cdl.countDown();
        }).start();
        cdl.await();
        totalCount = count1 + count2 + count3;
        System.out.println("totalCount=" + totalCount);
    }
}
