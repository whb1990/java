package main.java.com.study.lock.cyclicBarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: whb
 * @date: 2019/8/26 17:50
 * @description: 比赛赛马
 */
public class HorseRace implements Runnable {

    /**
     * 赛道长度
     */
    private static final int FINISH_LINE = 75;
    /**
     * 参加赛马的马屁集合
     */
    private static List<Horse> horses = new ArrayList<Horse>();
    /**
     * 线程池用于马儿奔跑
     */
    private static ExecutorService exec = Executors.newCachedThreadPool();

    @Override
    public void run() {
        StringBuilder s = new StringBuilder();
        //打印赛道边界
        for (int i = 0; i < FINISH_LINE; i++) {
            s.append("=");
        }
        System.out.println(s);
        //打印赛马轨迹
        for (Horse horse : horses) {
            System.out.println(horse.tracks());
        }
        //判断是否结束
        for (Horse horse : horses) {
            if (horse.getStrides() >= FINISH_LINE) {
                System.out.println(horse + "won!");
                exec.shutdownNow();
                return;
            }
        }
        //休息指定时间再到下一轮
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            System.out.println("barrier-action sleep interrupted");
        }
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(7, new HorseRace());
        for (int i = 0; i < 7; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

}
