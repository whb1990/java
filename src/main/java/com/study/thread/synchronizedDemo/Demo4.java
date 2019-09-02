package main.java.com.study.thread.synchronizedDemo;

/**
 * @author: whb
 * @date: 2019/9/2 10:17
 * @description: synchronized代码块可以更精确的控制冲突限制访问区域，有时候表现更高效率。
 */
public class Demo4 {

    public synchronized void synMethod() {
        for (int i = 0; i < 1000000; i++) {
            ;
        }
    }

    public void synBlock() {
        synchronized (this) {
            for (int i = 0; i < 1000000; i++) {
                ;
            }
        }
    }

    public static void main(String[] args) {
        Demo4 demo = new Demo4();

        long start, diff;
        // 获取当前时间(millis)
        start = System.currentTimeMillis();
        // 调用“synchronized方法”
        demo.synMethod();
        // 获取“时间差值”
        diff = System.currentTimeMillis() - start;
        System.out.println("synMethod() : " + diff);
        // 获取当前时间(millis)
        start = System.currentTimeMillis();
        // 调用“synchronized方法块”
        demo.synBlock();
        // 获取“时间差值”
        diff = System.currentTimeMillis() - start;
        System.out.println("synBlock()  : " + diff);
    }
}
