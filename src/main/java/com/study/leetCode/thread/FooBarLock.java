package main.java.com.study.leetCode.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author： whb
 * @description： LeetCode-1115-交替打印字符串
 * @date： 2020-10-14 15:52
 */
public class FooBarLock {
    private int n;

    public FooBarLock(int n) {
        this.n = n;
    }

    Lock lock = new ReentrantLock(true);
    volatile boolean permitFoo = true;

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (permitFoo) {
                    printFoo.run();
                    i++;
                    permitFoo = false;
                } else {
                    Thread.yield();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {


            lock.lock();
            try {
                if (!permitFoo) {
                    printBar.run();
                    i++;
                    permitFoo = true;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
