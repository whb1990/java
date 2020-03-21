package main.java.com.study.concurrentQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: whb
 * @date: 2020/3/9 18:09
 * @description:
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        final BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
        new Thread(() -> {
            int num = 0;
            try {
                while (true) {
                    String task = String.valueOf(num);
                    queue.put(task);
                    System.out.println("P " + task);
                    num++;
                    Thread.sleep((int) (Math.random() * 100));
                }
            } catch (InterruptedException e) {
            }
        }, "Producer").start();

        new Thread(() -> {
            try {
                while (true) {
                    String task = queue.take();
                    System.out.println("C " + task);
                    Thread.sleep((int) (Math.random() * 100));
                }
            } catch (InterruptedException e) {
            }
        }, "Consumer").start();
    }
}
