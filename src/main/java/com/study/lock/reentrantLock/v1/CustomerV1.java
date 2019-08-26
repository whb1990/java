package main.java.com.study.lock.reentrantLock.v1;

/**
 * @author: whb
 * @date: 2019/8/26 16:13
 * @description: 消费者
 */
public class CustomerV1 {
    private DepotV1 depotV1;

    public CustomerV1(DepotV1 depotV1) {
        this.depotV1 = depotV1;
    }

    /**
     * 消费产品：新建一个线程从仓库中消费产品。
     */
    public void consume(final int val) {
        new Thread(() -> depotV1.consume(val)).start();
    }
}
