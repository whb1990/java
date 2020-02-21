package main.java.com.study.thread.inOrder;

/**
 * @author: whb
 * @date: 2020/2/21 14:38
 * @description: 线程顺序执行方案一：使用线程join
 */
public class ThreadJoinDemo {
    public static void main(String[] args) {
        final Thread thread1 = new Thread(() -> System.out.println("产品经理规划新需求"));

        final Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
                System.out.println("开发人员开发新需求功能");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
                System.out.println("测试人员测试新功能");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("早上：");
        System.out.println("测试人员来上班了...");
        thread3.start();
        System.out.println("产品经理来上班了...");
        thread1.start();
        System.out.println("开发人员来上班了...");
        thread2.start();
    }
}
