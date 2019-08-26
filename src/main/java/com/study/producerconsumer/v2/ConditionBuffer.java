package main.java.com.study.producerconsumer.v2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: whb
 * @date: 2019/8/26 15:40
 * @description: 缓冲区
 */
public class ConditionBuffer {

    private final Lock lock = new ReentrantLock();
    /**
     * 不满
     */
    final Condition notFull = lock.newCondition();
    /**
     * 不空
     */
    final Condition notEmpty = lock.newCondition();
    /**
     * 缓冲区
     */
    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    //生产方法
    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                //队列已满, 线程在notFull队列上等待
                notFull.await();
            }
            items[putptr] = x;
            if (++putptr == items.length) {
                putptr = 0;
            }
            ++count;
            //生产成功, 唤醒notEmpty队列的结点
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    //消费方法
    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                //队列为空, 线程在notEmpty队列上等待
                notEmpty.await();
            }
            Object x = items[takeptr];
            if (++takeptr == items.length) {
                takeptr = 0;
            }
            --count;
            //消费成功, 唤醒notFull队列的结点
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

}
