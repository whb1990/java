package main.java.com.study.lock;

/**
 * Author:   whb
 * Date:     2019/5/22 10:06
 * Description: 死锁实现
 */
public class DeadLock {
    public void run() {
        TestDeadLock tl = new TestDeadLock();
        new Thread(tl, "线程A").start();
        new Thread(tl, "线程B").start();
    }

    class TestDeadLock implements Runnable {
        private Object objA = new Object();
        private Object objB = new Object();
        private boolean flag = true;

        @Override
        public void run() {
            if (flag) {
                flag = false;
                synchronized (objA) {
                    System.out.println(Thread.currentThread().getName() + "锁住资源A，等待资源B");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (objB) {
                        System.out.println(Thread.currentThread().getName() + "获得资源B");
                    }
                }
            } else {
                flag = true;
                synchronized (objB) {
                    System.out.println(Thread.currentThread().getName() + "锁住资源B，等待资源A");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (objA) {
                        System.out.println(Thread.currentThread().getName() + "获得资源A");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new DeadLock().run();
    }
}