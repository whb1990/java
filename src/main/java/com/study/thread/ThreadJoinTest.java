package main.java.com.study.thread;

/**
 * @author: whb
 * @date: 2019/8/26 17:10
 * @description: A线程需要用到B线程，C线程，D线程的结果
 * Thread的join()方法的原理：如果线程thread调用join()方法，那么它会阻塞当前正在运行的线程，记着是阻塞当前正在运行的线程，而不是阻塞thread线程，直到thread线程运行结束，才会继续往下执行。
 */
public class ThreadJoinTest {

    /**
     * 总和
     */
    private static int totalCount;
    /**
     * 结果1
     */
    private static int count1;
    /**
     * 结果2
     */
    private static int count2;
    /**
     * 结果3
     */
    private static int count3;

    public static void main(String[] args) throws InterruptedException {
        //主线程运行，启动3个线程
        Thread t1 = new Thread(() -> count1 = 10);
        Thread t2 = new Thread(() -> count2 = 20);
        Thread t3 = new Thread(() -> count3 = 30);
        t1.start();
        t2.start();
        t3.start();
        //主线程会被阻塞，直到线程t1运行结束
        t1.join();
        //主线程会被阻塞，直到线程t2运行结束
        t2.join();
        //主线程会被阻塞，直到线程t3运行结束
        t3.join();
        //主线程运行
        totalCount = count1 + count2 + count3;
        System.out.println("totalCount = " + totalCount);
    }
}
