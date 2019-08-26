package main.java.com.study.lock.reentrantLock.v2;

/**
 * @author: whb
 * @date: 2019/8/26 16:18
 * @description: 消费者
 */
public class CustomerV2 {
    private DepotV2 depotV2;

    public CustomerV2(DepotV2 depotV2) {
        this.depotV2 = depotV2;
    }

    /**
     * 消费产品：新建一个线程从仓库中消费产品。
     *
     * @param val
     */
    public void consume(final int val) {
        new Thread(() -> depotV2.consume(val)).start();
    }
}
