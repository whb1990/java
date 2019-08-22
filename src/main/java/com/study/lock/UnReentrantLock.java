package main.java.com.study.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: whb
 * @date: 2019/8/22 10:06
 * @description: 自旋锁模拟不可重入锁
 */
public class UnReentrantLock {

    private AtomicReference<Thread> owner = new AtomicReference<>();

    /**
     * 加锁
     */
    public void lock() {
        Thread current = Thread.currentThread();
        //经典的自旋语法
        for (; ; ) {
            if (!owner.compareAndSet(null, current)) {
                return;
            }
        }
    }

    /**
     * 解锁
     */
    public void unlock() {
        Thread current = Thread.currentThread();
        owner.compareAndSet(current, null);
    }
}
