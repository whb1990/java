package main.java.com.study.producerconsumer.v1;

/**
 * @author: whb
 * @date: 2019/8/26 14:12
 * @description: 生产者
 */
public class Product implements Runnable {

    private SynCache synCache;

    public Product(SynCache synCache) {
        this.synCache = synCache;
    }

    @Override
    public void run() {
        int count = 1;
        for (; ; ) {
            String data = "a" + count;
            synCache.product(data);
            System.out.println("生产者生产了数据：" + data);
            count++;
        }
    }
}
