package main.java.com.study.lock.reentrantLock.v3;

/**
 * @author: whb
 * @date: 2019/8/26 16:24
 * @description: 消费者
 */
public class Customer {
    private Depot depot;

    public Customer(Depot depot) {
        this.depot = depot;
    }

    /**
     * 消费产品：新建一个线程从仓库中消费产品。
     *
     * @param val
     */
    public void consume(final int val) {
        new Thread(() -> depot.consume(val)).start();
    }
}
