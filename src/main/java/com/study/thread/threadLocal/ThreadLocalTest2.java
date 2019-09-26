package main.java.com.study.thread.threadLocal;

/**
 * @author: whb
 * @date: 2019/9/26 17:43
 * @description: ThreadLocal测试示例2--不支持继承性
 */
public class ThreadLocalTest2 {
    /**
     * 创建ThreadLocal变量
     */
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        //在main线程中添加main线程的本地变量
        threadLocal.set("mainVal");
        //新创建一个子线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程中的本地变量值:" + threadLocal.get());
            }
        });
        thread.start();
        //输出main线程中的本地变量值
        System.out.println("mainx线程中的本地变量值:" + threadLocal.get());
    }
}
