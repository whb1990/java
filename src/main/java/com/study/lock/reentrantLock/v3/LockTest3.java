package main.java.com.study.lock.reentrantLock.v3;

/**
 * @author: whb
 * @date: 2019/8/26 16:27
 * @description: Lock联合Condition测试生产-消费
 */
public class LockTest3 {
    public static void main(String[] args) {
        Depot mDepot = new Depot(100);
        Producer mPro = new Producer(mDepot);
        Customer mCus = new Customer(mDepot);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}
