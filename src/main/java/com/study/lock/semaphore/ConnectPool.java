package main.java.com.study.lock.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: whb
 * @date: 2019/8/27 10:21
 * @description: 连接池
 */
public class ConnectPool {
    /**
     * 连接池大小
     */
    private int size;
    /**
     * 连接集合
     */
    private Connect[] connects;
    /**
     * 连接状态标志
     */
    private boolean[] connectFlag;
    /**
     * 剩余可用连接数
     */
    private volatile int available;
    /**
     * 信号量
     */
    private Semaphore semaphore;

    public ConnectPool(int size) {
        this.size = size;
        this.available = size;
        semaphore = new Semaphore(size, true);
        connects = new Connect[size];
        connectFlag = new boolean[size];
        initConnects();
    }

    /**
     * 初始化连接
     */
    private void initConnects() {
        //生成指定数量的连接
        for (int i = 0; i < this.size; i++) {
            connects[i] = new Connect();
        }
    }

    /**
     * 获取连接
     */
    private synchronized Connect getConnect() {
        for (int i = 0; i < connectFlag.length; i++) {
            //遍历集合找到未使用的连接
            if (!connectFlag[i]) {
                //将连接设置为使用中
                connectFlag[i] = true;
                //可用连接数减一
                available--;
                System.out.println("【" + Thread.currentThread().getName() + "】已获取连接，剩余可用连接：" + available);
                //返回连接
                return connects[i];
            }
        }
        return null;
    }

    /**
     * 打开链接
     *
     * @return
     */
    public Connect openConnect() throws InterruptedException {
        //获取许可
        semaphore.acquire();
        //获取连接
        return getConnect();
    }

    /**
     * 释放连接
     */
    public synchronized void release(Connect connect) {
        for (int i = 0; i < this.size; i++) {
            if (connect == connects[i]) {
                //将连接设置为未使用
                connectFlag[i] = false;
                //可用连接加一
                available++;
                System.out.println("【" + Thread.currentThread().getName() + "】已释放连接，剩余可用连接：" + available);
                //释放许可
                semaphore.release();
            }
        }
    }
}

class Connect {
    private static int count = 1;
    private int id = count++;

    public Connect() {
        //模拟打开一个连接很耗费资源，需要等待1秒
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("连接#" + id + "#已与数据库建立通道！");
    }

    @Override
    public String toString() {
        return "【" + id + "】";
    }
}
