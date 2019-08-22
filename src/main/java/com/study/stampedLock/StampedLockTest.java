package main.java.com.study.stampedLock;

import java.util.concurrent.locks.StampedLock;

/**
 * @author: whb
 * @date: 2019/8/20 14:43
 * @description: StampedLock测试类
 */
public class StampedLockTest {

    private double x, y;
    private final StampedLock stampedLock = new StampedLock();

    /**
     * 独占锁方法
     *
     * @param deltax
     * @param deltaY
     */
    void move(double deltax, double deltaY) {
        long stamp = stampedLock.writeLock();
        try {
            x += deltax;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    /**
     * 读锁
     */
    double distanceFromOrigin() {
        long stamp = stampedLock.tryOptimisticRead();
        double currentX = x, currentY = y;
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
