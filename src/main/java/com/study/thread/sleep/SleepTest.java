package main.java.com.study.thread.sleep;

/**
 * @author: whb
 * @date: 2019/9/2 14:24
 * @description: 线程休眠测试
 */
public class SleepTest {
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("t1");
        t1.start();
    }
}

class ThreadA extends Thread {
    public ThreadA(String name) {
        super(name);
    }

    @Override
    public synchronized void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s: %d\n", this.getName(), i);
                // i能被4整除时，休眠100毫秒
                if (i % 4 == 0) {
                    Thread.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}