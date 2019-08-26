package main.java.com.study.lock.reentrantLock.v2;

/**
 * @author: whb
 * @date: 2019/8/26 16:19
 * @description: 生产者
 */
public class ProducerV2 {
    private DepotV2 depotV2;

    public ProducerV2(DepotV2 depotV2) {
        this.depotV2 = depotV2;
    }

    /**
     * 消费产品：新建一个线程向仓库中生产产品。
     *
     * @param val
     */
    public void produce(final int val) {
        new Thread(() -> depotV2.produce(val)).start();
    }
}
