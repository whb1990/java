package main.java.com.study.lock.reentrantLock.v1;

/**
 * @author: whb
 * @date: 2019/8/26 16:14
 * @description: 通过独占锁测试生产-消费
 */
public class LockTest1 {
    public static void main(String[] args) {
        DepotV1 mDepotV1 = new DepotV1();
        ProducerV1 mPro = new ProducerV1(mDepotV1);
        CustomerV1 mCus = new CustomerV1(mDepotV1);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}
