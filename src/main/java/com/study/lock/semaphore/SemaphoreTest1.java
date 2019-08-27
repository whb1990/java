package main.java.com.study.lock.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: whb
 * @date: 2019/8/27 10:04
 * @description: Semaphore测试类
 */
public class SemaphoreTest1 {

    private static final int SEM_MAX = 10;

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(SEM_MAX);
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //在线程池中执行任务
        threadPool.execute(new MyThread(sem, 5));
        threadPool.execute(new MyThread(sem, 4));
        threadPool.execute(new MyThread(sem, 7));
        //关闭线程池
        threadPool.shutdown();
    }

    static class MyThread extends Thread {
        /**
         * 信号量
         */
        private volatile Semaphore sem;

        /**
         * 申请信号量大小
         */
        private int count;

        public MyThread(Semaphore sem, int count) {
            this.sem = sem;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                //从信号量中获取count个许可
                sem.acquire(count);
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " acquire count = " + count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //释放给定数目的许可
                sem.release(count);
                System.out.println(Thread.currentThread().getName() + " release " + count);
            }
        }
    }
}
