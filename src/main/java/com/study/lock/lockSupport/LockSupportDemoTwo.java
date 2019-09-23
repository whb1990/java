package main.java.com.study.lock.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: whb
 * @date: 2019/9/23 17:17
 * @description: LockSupport测试示例
 *
 * 执行结果：
 *main start2
 *  漂亮的分割线---
 * main start1
 * Thread-0-线程2开始park before
 * Thread-1 wakup before
 * 解锁后休息三秒哦
 * Thread-0-线程2park after
 * Thread-1 wakup after
 * ------------------------------------------------------------------------------
 * 结果说明：
 * 其实看结果就是线程2阻塞了，线程1唤醒了线程2.就这么简单。
 */
public class LockSupportDemoTwo {
    public static void main(String args[]) {
        Thread thread = Thread.currentThread();

        ThreadParkService2 service2 = new ThreadParkService2(thread);
        System.out.println(Thread.currentThread().getName() + " start2");
        service2.start();

        System.out.println(" 漂亮的分割线---");

        ThreadParkService service = new ThreadParkService(service2);
        System.out.println(Thread.currentThread().getName() + " start1");
        service.start();
    }
}

class ThreadParkService2 extends Thread {

    private Thread thread;

    public ThreadParkService2(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "-线程2开始park before");
        //阻塞当前执行的线程，不能阻塞其他线程，看源码哦。里面阻塞时并不需要任何传参。
        LockSupport.park(this);
        //这里并不会阻塞thread线程，阻塞的还是当前线程。thread只是做一个标记方便被锁的对象。
        //LockSupport.park(thread);
        System.out.println(Thread.currentThread().getName() + "-线程2park after");

    }
}
