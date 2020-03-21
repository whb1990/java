package main.java.com.study.concurrentQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author: whb
 * @date: 2020/3/9 18:12
 * @description:
 */
public class SynchronousQueueTest {
    public static void main(String[] args) {
        final BlockingQueue<String> queue = new SynchronousQueue<>();
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
