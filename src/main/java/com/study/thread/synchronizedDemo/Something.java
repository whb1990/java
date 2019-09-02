package main.java.com.study.thread.synchronizedDemo;

/**
 * @author: whb
 * @date: 2019/9/2 10:28
 * @description: Something对象
 */
public class Something {
    public synchronized void isSyncA() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : isSyncA");
            }
        } catch (InterruptedException ie) {
        }
    }

    public synchronized void isSyncB() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : isSyncB");
            }
        } catch (InterruptedException ie) {
        }
    }

    public static synchronized void cSyncA() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : cSyncA");
            }
        } catch (InterruptedException ie) {
        }
    }

    public static synchronized void cSyncB() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : cSyncB");
            }
        } catch (InterruptedException ie) {
        }
    }
}
