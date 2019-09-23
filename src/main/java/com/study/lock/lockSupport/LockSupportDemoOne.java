package main.java.com.study.lock.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: whb
 * @date: 2019/9/23 17:05
 * @description: LockSupport测试类
 * <p>
 * 打印结果：
 * main start1
 * Thread-0 wakup before
 * 解锁后休息三秒哦
 * main center
 * end
 * Thread-0 wakup after
 * -----------------------------------------------------------------------------------
 * 结果说明：
 * 主线程main先打印了自己的东西，主线程到了park时被阻塞了。
 * 线程1异步执行打印了 wakup before
 * main center打印在“解锁后休息3s哦”说明线程1中的unpark先与park执行。
 * 线程1执行了unpark了，这个时候主线程中的park立马被唤醒，开始执行了end。
 * 然后线程1等待了3s后执行了wakup after。
 * ————————————————--------------------------------------
 * unpark，可以在park之前执行。它们一对一哦。不管什么时候park只要有unpark过一次就好了。
 * <p>
 * park被阻塞后，unpark执行后park立即被唤醒。与wait与notify不同，notify唤醒wait后，还必须等待notify代码块中的代码执行完毕后wait才能执行。
 */
public class LockSupportDemoOne {
    public static void main(String args[]) {
        Thread thread = Thread.currentThread();

        ThreadParkService service = new ThreadParkService(thread);
        System.out.println(Thread.currentThread().getName() + " start1");
        service.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " center");
        LockSupport.park(thread);
        System.out.println("end");

    }

}

class ThreadParkService extends Thread {

    private Thread thread;

    public ThreadParkService(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " wakup before");
        LockSupport.unpark(thread);//解锁后线程2立马就可以执行了。
        try {
            System.out.println("解锁后休息三秒哦");
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " wakup after");

    }
}
