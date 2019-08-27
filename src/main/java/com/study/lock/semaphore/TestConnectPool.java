package main.java.com.study.lock.semaphore;

/**
 * @author: whb
 * @date: 2019/8/27 10:36
 * @description: 测试连接池
 */
public class TestConnectPool extends Thread {

    private static ConnectPool pool = new ConnectPool(3);

    @Override
    public void run() {
        try {
            Connect connect = pool.openConnect();
            Thread.sleep(100);
            pool.release(connect);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new TestConnectPool().start();
        }
    }
}