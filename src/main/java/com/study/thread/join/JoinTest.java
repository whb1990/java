package main.java.com.study.thread.join;

/**
 * @author: whb
 * @date: 2019/9/2 15:26
 * @description: join() 的作用：让“主线程”等待“子线程”结束之后才能继续运行。
 */
public class JoinTest {

    public static void main(String[] args) {
        try {
            // 新建“线程t1”
            ThreadA t1 = new ThreadA("t1");

            t1.start();                     // 启动“线程t1”
            t1.join();                        // 将“线程t1”加入到“主线程main”中，并且“主线程main()会等待它的完成”
            System.out.printf("%s finish\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.printf("%s start\n", this.getName());

            // 延时操作
            for (int i = 0; i < 1000000; i++) {
                ;
            }

            System.out.printf("%s finish\n", this.getName());
        }
    }
}
