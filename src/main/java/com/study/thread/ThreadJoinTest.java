package main.java.com.study.thread;

/**
 * @author: whb
 * @date: 2019/8/26 17:10
 * @description: A线程需要用到B线程，C线程，D线程的结果
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
        Thread t1 = new Thread(() -> count1 = 10);
        Thread t2 = new Thread(() -> count2 = 20);
        Thread t3 = new Thread(() -> count3 = 30);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        totalCount = count1 + count2 + count3;
        System.out.println("totalCount = " + totalCount);
    }
}
