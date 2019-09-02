package main.java.com.study.thread.interrupt;

/**
 * @author: whb
 * @date: 2019/9/2 16:21
 * @description: 线程终止示例3
 */
public class Demo3 {

    public static void main(String[] args) {
        try {
            // 新建“线程t1”
            TestThread t1 = new TestThread("t1");
            System.out.println(t1.getName() + " (" + t1.getState() + ") is new.");

            t1.start();                      // 启动“线程t1”
            System.out.println(t1.getName() + " (" + t1.getState() + ") is started.");

            // 主线程休眠300ms，然后主线程给t1发“中断”指令。
            Thread.sleep(300);
            t1.stopTask();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted.");

            // 主线程休眠300ms，然后查看t1的状态。
            Thread.sleep(300);
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TestThread extends Thread {

    private volatile boolean flag = true;

    public void stopTask() {
        flag = false;
    }

    public TestThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                int i = 0;
                while (flag) {
                    Thread.sleep(100);
                    i++;
                    System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
                }
            } catch (InterruptedException ie) {
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException.");
            }
        }
    }
}