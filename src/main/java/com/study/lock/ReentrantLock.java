package main.java.com.study.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: whb
 * @date: 2019/8/22 10:10
 * @description: 自旋锁模拟可重入锁
 */
public class ReentrantLock {

    private AtomicReference<Thread> owner = new AtomicReference<>();
    //记录重入次数
    private volatile int state = 0;

    /**
     * 加锁
     */
    public void lock() {
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            state++;
            return;
        }
        for (; ; ) {
            if (!owner.compareAndSet(null, current)) {
                return;
            }
        }
    }

    /**
     * 释放锁
     */
    public void unlock() {
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            if (state != 0) {
                state--;
            } else {
                owner.compareAndSet(current, null);
            }
        }
    }
}
