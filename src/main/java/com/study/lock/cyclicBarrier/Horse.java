package main.java.com.study.lock.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: whb
 * @date: 2019/8/26 17:48
 * @description: 赛马
 */
public class Horse implements Runnable {

    /**
     * 参与者数量
     */
    private static int counter = 0;
    /**
     * 参与者ID
     */
    private final int id = counter++;
    /**
     * 运动路径长度
     */
    private int strides = 0;
    /**
     * 每次运动的长度
     */
    private static Random rand = new Random(50);
    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier b) {
        barrier = b;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    //赛马每次随机跑几步
                    strides += rand.nextInt(3);
                }
                barrier.await();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 运动路径
     *
     * @return
     */
    public String tracks() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            s.append("*");
        }
        s.append(id);
        return s.toString();
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public String toString() {
        return "Horse " + id + " ";
    }

}
