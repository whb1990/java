package main.java.com.study.thread.priority;

/**
 * @author: whb
 * @date: 2019/9/2 16:47
 * @description: 守护线程示例
 */
public class DaemonDemo {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()
                + "(isDaemon=" + Thread.currentThread().isDaemon() + ")");
        // 新建线程t1
        Thread t1 = new MyThread2("t1");
        // 新建线程t2
        Thread t2 = new MyDaemon("t2");
        // 设置t2为守护线程
        t2.setDaemon(true);
        // 启动t1
        t1.start();
        // 启动t2
        t2.start();
    }
}

class MyThread2 extends Thread {
    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(3);
                System.out.println(this.getName() + "(isDaemon=" + this.isDaemon() + ")" + ", loop " + i);
            }
        } catch (InterruptedException e) {
        }
    }
};

class MyDaemon extends Thread {
    public MyDaemon(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                Thread.sleep(1);
                System.out.println(this.getName() + "(isDaemon=" + this.isDaemon() + ")" + ", loop " + i);
            }
        } catch (InterruptedException e) {
        }
    }
}