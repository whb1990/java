package main.java.com.study.lock.reentrantLock.v1;

/**
 * @author: whb
 * @date: 2019/8/26 16:12
 * @description: 生产者
 */
public class ProducerV1 {

    private DepotV1 depotV1;

    public ProducerV1(DepotV1 depotV1) {
        this.depotV1 = depotV1;
    }

    /**
     * 消费产品：新建一个线程向仓库中生产产品。
     */
    public void produce(final int val) {
        new Thread(() -> depotV1.produce(val)).start();
    }
}
