package main.java.com.study.lock.reentrantReadWriteLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: whb
 * @date: 2019/8/27 14:56
 * @description: 读写锁测试
 * 读锁是共享的，写锁是独占的.
 * 1：如果有一个线程获取了读锁，其他线程可以获取读锁，但是不能获取写锁了。
 * 2：如果一个线程获取了写锁，其他线程读锁和写锁都不能获取。
 */
public class ReentrantReadWriteLockTest {
    /**
     * 读写锁
     */
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    /**
     * 读锁
     */
    private static final Lock readLock = lock.readLock();
    /**
     * 写锁
     */
    private static final Lock writeLock = lock.writeLock();
    /**
     * 计数器1
     */
    private static CountDownLatch cd1 = new CountDownLatch(6);
    /**
     * 计数器2
     */
    private static CountDownLatch cd2 = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            final int finalI = (i + 1);
            new Thread(() -> {
                try {
                    cd1.countDown();
                    cd2.await();
                    readLock.lock();
                    System.out.println("读线程【" + finalI + "】获取了读锁");
                } catch (Exception e) {

                } finally {
                    System.out.println("读线程【" + finalI + "】释放了读锁");
                    readLock.unlock();
                }
            }).start();
        }
        for (int i = 0; i < 3; i++) {
            final int finalI = (i + 1);
            new Thread(() -> {
                try {
                    cd1.countDown();
                    cd2.await();
                    writeLock.lock();
                    System.out.println("写线程【" + finalI + "】获取了写锁");
                } catch (Exception e) {

                } finally {
                    System.out.println("写线程【" + finalI + "】释放了写锁");
                    writeLock.unlock();
                }
            }).start();
        }
        cd1.await();
        System.out.println("所有的线程准备就绪");
        cd2.countDown();
    }
}
