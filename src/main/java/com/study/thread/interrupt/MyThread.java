package main.java.com.study.thread.interrupt;

/**
 * @author: whb
 * @date: 2019/9/2 16:15
 * @description: 线程对象
 */
public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        while (!isInterrupted()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException.");
            }
            i++;
            System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
        }
    }
}
