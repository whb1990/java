package main.java.com.study.thread;

/**
 * Author:   whb
 * Date:     2019/5/21 22:04
 * Description: Thread的start()和run()方法区别
 */
class TestThread extends Thread {
    public TestThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
};

public class ThreadMethodDemo {
    public static void main(String[] args) {
        Thread mythread = new TestThread("testThread");

        System.out.println(Thread.currentThread().getName() + " call testThread.run()");
        mythread.run();

        System.out.println(Thread.currentThread().getName() + " call testThread.start()");
        mythread.start();
    }
}