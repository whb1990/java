package main.java.com.study.lock;

/**
 * @author: whb
 * @date: 2019/8/26 15:14
 * @description: ReentrantLock测试类
 */
public class ReentrantLockTest {
    private static int count = 0;
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
                    for (int j = 0; j < 1000; j++) {
                        count++;
                    }
                } finally {
                    lock.unlock();
                }
            }).start();
        }
        Thread.sleep(5000);
        System.out.println("count=" + count);
    }
}
