package main.java.com.study.thread;

/**
 * Author:   whb
 * Date:     2019/5/21 21:43
 * Description: Runnable实现多线程
 */
class MyThread2 implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖票：ticket" + this.ticket--);
            }
        }
    }
};

public class RunnableTest {
    public static void main(String[] args) {
        MyThread2 mt = new MyThread2();

        // 启动3个线程t1,t2,t3(它们共用一个Runnable对象)，这3个线程一共卖10张票！
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        Thread t3 = new Thread(mt);
        t1.start();
        t2.start();
        t3.start();
    }
}
