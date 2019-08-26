package main.java.com.study.producerconsumer.v1;

/**
 * @author: whb
 * @date: 2019/8/26 14:14
 * @description: 消费者
 */
public class Consume implements Runnable {

    private SynCache synCache;

    public Consume(SynCache synCache) {
        this.synCache = synCache;
    }

    @Override
    public void run() {
        for (; ; ) {
            System.out.println("消费者消费了数据：" + synCache.consume());
        }
    }
}
