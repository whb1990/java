package main.java.com.study.lock.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: whb
 * @date: 2019/8/27 14:07
 * @description: 阻塞原语测试
 */
public class LockSupportTest {
    /**
     * 主线程
     */
    private static Thread mainThread;

    public static void main(String[] args) {
        ThreadA ta = new ThreadA("ta");
        //获取主线程
        mainThread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " start ta");
        //启动线程ta
        ta.start();
        System.out.println(Thread.currentThread().getName() + " block");
        //主线程阻塞
        LockSupport.park(mainThread);
        System.out.println(Thread.currentThread().getName() + " continue");
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " wakeup others.");
            LockSupport.unpark(mainThread);
        }
    }
}
