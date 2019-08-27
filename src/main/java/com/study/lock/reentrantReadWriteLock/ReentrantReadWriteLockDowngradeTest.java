package main.java.com.study.lock.reentrantReadWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: whb
 * @date: 2019/8/27 15:12
 * @description: 读写锁降级测试
 * 在获取到写锁后，然后获取读锁，此时写锁并没有释放，读锁获取成功了，然后才释放的写锁，
 * 这种获取写锁——获取读锁——释放写锁——释放读锁的操作步骤就是锁降级(从写锁降级到读锁)，但是反过来就不可以了，也就是说读锁不能升级到写锁
 */
public class ReentrantReadWriteLockDowngradeTest {
    /**
     * 读写锁
     */
    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    /**
     * 读锁
     */
    private static final Lock readLock = readWriteLock.readLock();
    /**
     * 写锁
     */
    private static final Lock writeLock = readWriteLock.writeLock();

    public static void main(String[] args) {
        try {
            writeLock.lock();
            System.out.println("获取写锁");
            try {
                readLock.lock();
                System.out.println("获取读锁");
            } finally {
                writeLock.unlock();
                System.out.println("释放写锁");
            }
        } finally {
            readLock.unlock();
            System.out.println("释放读锁");
        }
    }
}
