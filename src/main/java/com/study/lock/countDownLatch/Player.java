package main.java.com.study.lock.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author: whb
 * @date: 2019/8/26 17:08
 * @description: 在玩欢乐斗地主时必须等待三个玩家都到齐才可以进行发牌。
 */
public class Player extends Thread {
    private static int count = 1;
    private final int id = count++;
    private CountDownLatch latch;

    public Player(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("【玩家" + id + "】已入场");
        latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        System.out.println("牌局开始, 等待玩家入场...");
        new Player(latch).start();
        new Player(latch).start();
        new Player(latch).start();
        //如果注释掉下面这行代码，就不能保证所有玩家到齐之后开始发牌
        latch.await();
        System.out.println("玩家已到齐, 开始发牌...");
    }
}
