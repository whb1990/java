package main.java.com.study.lock.reentrantLock.v3;

/**
 * @author: whb
 * @date: 2019/8/26 16:24
 * @description: 生产者
 */
public class Producer {
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    /**
     * 消费产品：新建一个线程向仓库中生产产品。
     *
     * @param val
     */
    public void produce(final int val) {
        new Thread(() -> depot.produce(val)).start();
    }
}
