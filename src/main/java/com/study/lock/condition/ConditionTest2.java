package main.java.com.study.lock.condition;

/**
 * @author: whb
 * @date: 2019/8/26 16:49
 * @description: Condition条件测试
 */
public class ConditionTest2 {

    private static BoundedBuffer bb = new BoundedBuffer();

    public static void main(String[] args) {
        // 启动10个“写线程”，向BoundedBuffer中不断的写数据(写入0-9)；
        // 启动10个“读线程”，从BoundedBuffer中不断的读数据。
        for (int i = 0; i < 10; i++) {
            new PutThread("p" + i, i).start();
            new TakeThread("t" + i).start();
        }
    }

    static class PutThread extends Thread {
        private int num;

        public PutThread(String name, int num) {
            super(name);
            this.num = num;
        }

        @Override
        public void run() {
            try {
                // 线程休眠1ms
                Thread.sleep(1);
                // 向BoundedBuffer中写入数据
                bb.put(num);
            } catch (InterruptedException e) {
            }
        }
    }

    static class TakeThread extends Thread {
        public TakeThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                // 线程休眠1ms
                Thread.sleep(10);
                // 从BoundedBuffer中取出数据
                Integer num = (Integer) bb.take();
            } catch (InterruptedException e) {
            }
        }
    }
}
