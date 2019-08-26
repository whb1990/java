package main.java.com.study.producerconsumer.v1;

/**
 * @author: whb
 * @date: 2019/8/26 14:15
 * @description: 生产者-消费者模型测试
 */
public class Test {

    public static void main(String[] args) {
        SynCache synCache = new SynCache();
        Product product = new Product(synCache);
        Consume consume = new Consume(synCache);
        new Thread(product).start();
        new Thread(consume).start();
    }
}
