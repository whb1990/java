package main.java.com.study.thread.priority;

/**
 * @author: whb
 * @date: 2019/9/2 16:43
 * @description: 线程优先级测试
 */
public class PriorityDemo {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()
                + "(" + Thread.currentThread().getPriority() + ")");
        // 新建线程t1
        Thread t1 = new MyThread("t1");
        // 新建线程t2
        Thread t2 = new MyThread("t2");
        // 设置t1的优先级为1
        t1.setPriority(1);
        // 设置t2的优先级为10
        t2.setPriority(10);
        // 启动t1
        t1.start();
        // 启动t2
        t2.start();
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()
                    + "(" + Thread.currentThread().getPriority() + ")"
                    + ", loop " + i);
        }
    }
};