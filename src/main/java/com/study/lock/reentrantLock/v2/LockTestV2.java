package main.java.com.study.lock.reentrantLock.v2;

/**
 * @author: whb
 * @date: 2019/8/26 16:22
 * @description: 不加锁测试生产-消费
 */
public class LockTestV2 {
    public static void main(String[] args) {
        DepotV2 mDepotV2 = new DepotV2();
        ProducerV2 mPro = new ProducerV2(mDepotV2);
        CustomerV2 mCus = new CustomerV2(mDepotV2);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}
