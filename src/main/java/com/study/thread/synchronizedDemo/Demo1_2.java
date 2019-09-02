package main.java.com.study.thread.synchronizedDemo;

/**
 * @author: whb
 * @date: 2019/9/2 10:06
 * @description: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
 */
public class Demo1_2 {
    public static void main(String[] args) {
        // 新建“线程t1”
        Thread t1 = new MyThread("t1");
        // 新建“线程t2”
        Thread t2 = new MyThread("t2");
        t1.start();                          // 启动“线程t1”
        t2.start();                          // 启动“线程t2”
    }
}

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    // 休眠100ms
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                }
            } catch (InterruptedException ie) {
            }
        }
    }
}