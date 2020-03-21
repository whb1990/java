package main.java.com.study.concurrentQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author: whb
 * @date: 2020/3/9 18:10
 * @description:
 */
public class DelayQueueTest {
    static BlockingQueue<MyTask> tasks = new DelayQueue<>();

    /**
     * 需要实现Delayed
     */
    static class MyTask implements Delayed {
        long runningTime;
        String name;

        MyTask(long rt, String name) {
            this.runningTime = rt;
            this.name = name;
        }

        /**
         * 按照运行时间短的，先运行
         *
         * @param o
         * @return
         */
        @Override
        public int compareTo(Delayed o) {
            return (int) (getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(runningTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long curTime = System.currentTimeMillis();
        MyTask t1 = new MyTask(curTime + 1000, "t1");
        MyTask t2 = new MyTask(curTime + 2000, "t2");
        MyTask t3 = new MyTask(curTime + 1500, "t3");
        MyTask t4 = new MyTask(curTime + 2500, "t4");
        MyTask t5 = new MyTask(curTime + 500, "t5"); // 时间最短的，先运行
        // 按照 5 1 3 2 4的顺序执行

        tasks.put(t1);
        tasks.put(t2);
        tasks.put(t3);
        tasks.put(t4);
        tasks.put(t5);

        System.out.println(tasks);

        for (int i = 0; i < 5; i++) System.out.println(tasks.take());

    }
}
