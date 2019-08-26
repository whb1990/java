package main.java.com.study.lock.reentrantLock.v1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: whb
 * @date: 2019/8/26 16:10
 * @description: 仓库
 */
public class DepotV1 {
    /**
     * 仓库的实际数量
     */
    private int size;
    /**
     * 独占锁
     */
    private Lock lock;

    public DepotV1() {
        this.size = 0;
        this.lock = new ReentrantLock();
    }

    /**
     * 生产
     *
     * @param val
     */
    public void produce(int val) {
        lock.lock();
        try {
            size += val;
            System.out.printf("%s produce(%d) --> size=%d\n",
                    Thread.currentThread().getName(), val, size);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 消费
     *
     * @param val
     */
    public void consume(int val) {
        lock.lock();
        try {
            size -= val;
            System.out.printf("%s consume(%d) <-- size=%d\n",
                    Thread.currentThread().getName(), val, size);
        } finally {
            lock.unlock();
        }
    }
}
