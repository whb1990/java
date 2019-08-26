package main.java.com.study.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: whb
 * @date: 2019/8/26 16:46
 * @description: 通过Condition的await(), signal()来演示线程的休眠/唤醒功能。
 */
public class ConditionTest1 {

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {

        ThreadA ta = new ThreadA("ta");
        // 获取锁
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " start ta");
            ta.start();

            System.out.println(Thread.currentThread().getName() + " block");
            // 等待
            condition.await();

            System.out.println(Thread.currentThread().getName() + " continue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    static class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            // 获取锁
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " wakup others");
                // 唤醒“condition所在锁上的其它线程”
                condition.signal();
            } finally {
                // 释放锁
                lock.unlock();
            }
        }
    }
}
