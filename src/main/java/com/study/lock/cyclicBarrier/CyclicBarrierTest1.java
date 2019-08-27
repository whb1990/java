package main.java.com.study.lock.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: whb
 * @date: 2019/8/27 9:06
 * @description: 新建5个线程，这5个线程达到一定的条件时，它们才继续往后运行。
 */
public class CyclicBarrierTest1 {

    private static int SIZE = 5;
    private static CyclicBarrier cb;

    public static void main(String[] args) {
        cb = new CyclicBarrier(SIZE);
        for (int i = 0; i < SIZE; i++) {
            new InnerThread().start();
        }
    }

    static class InnerThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");
                //将cb的参与者数量加1
                cb.await();
                //cb的参与者数量等于5时，才能继续往下执行
                System.out.println(Thread.currentThread().getName() + " continued.");
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
