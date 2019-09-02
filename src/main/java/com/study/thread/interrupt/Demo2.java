package main.java.com.study.thread.interrupt;

/**
 * @author: whb
 * @date: 2019/9/2 16:14
 * @description: 线程终止示例2
 */

public class Demo2 {

    public static void main(String[] args) {
        try {
            // 新建“线程t1”
            Thread t1 = new MyThread("t1");
            System.out.println(t1.getName() + " (" + t1.getState() + ") is new.");
            // 启动“线程t1”
            t1.start();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is started.");

            // 主线程休眠300ms，然后主线程给t1发“中断”指令。
            Thread.sleep(300);
            t1.interrupt();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted.");

            // 主线程休眠300ms，然后查看t1的状态。
            Thread.sleep(300);
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
