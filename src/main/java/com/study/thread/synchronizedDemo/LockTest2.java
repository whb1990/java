package main.java.com.study.thread.synchronizedDemo;

/**
 * @author: whb
 * @date: 2019/9/2 10:22
 * @description: 实例锁和全局锁示例2
 * 可以同时被访问。因为访问的不是同一个对象的同步锁，x.isSyncA()访问的是x的同步锁，而y.isSyncA()访问的是y的同步锁。
 */
public class LockTest2 {

    Something x = new Something();
    Something y = new Something();

    /**
     * 比较(02) x.isSyncA()与y.isSyncA()
     */
    private void test2() {
        // 新建t21, t21会调用 x.isSyncA()
        Thread t21 = new Thread(
                () -> x.isSyncA(), "t21");

        // 新建t22, t22会调用 x.isSyncB()
        Thread t22 = new Thread(
                () -> y.isSyncA(), "t22");


        t21.start();  // 启动t21
        t22.start();  // 启动t22
    }

    public static void main(String[] args) {
        LockTest2 demo = new LockTest2();

        demo.test2();
    }
}
