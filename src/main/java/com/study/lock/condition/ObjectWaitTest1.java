package main.java.com.study.lock.condition;

/**
 * @author: whb
 * @date: 2019/8/26 16:44
 * @description: 通过Object的wait()，notify()演示线程的休眠/唤醒
 */
public class ObjectWaitTest1 {

    public static void main(String[] args) {

        ThreadA ta = new ThreadA("ta");
        // 通过synchronized(ta)获取“对象ta的同步锁”
        synchronized (ta) {
            try {
                System.out.println(Thread.currentThread().getName() + " start ta");
                ta.start();

                System.out.println(Thread.currentThread().getName() + " block");
                // 等待
                ta.wait();

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            // 通过synchronized(this)获取“当前对象的同步锁”
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " wakup others");
                // 唤醒“当前对象上的等待线程”
                notify();
            }
        }
    }
}
