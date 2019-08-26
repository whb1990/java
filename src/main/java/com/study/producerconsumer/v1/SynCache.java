package main.java.com.study.producerconsumer.v1;

/**
 * @author: whb
 * @date: 2019/8/26 14:08
 * @description: 缓冲区
 */
public class SynCache {

    /**
     * 缓冲区
     */
    private String[] data = new String[10];

    /**
     * 缓冲区数组索引
     */
    private int index;

    /**
     * 生产数据
     *
     * @param productData
     */
    public void product(String productData) {
        synchronized (this) {
            if (index == data.length) {
                try {
                    System.out.println("缓冲区已满，生产者被阻塞...");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data[index] = productData;
            index++;
            this.notify();
        }
    }

    /**
     * 消费数据
     *
     * @return
     */
    public String consume() {
        synchronized (this) {
            if (index == 0) {
                try {
                    System.out.println("缓冲区已空，消费者被阻塞...");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.notify();
            index--;
            String consumeData = data[index];
            return consumeData;
        }
    }
}
