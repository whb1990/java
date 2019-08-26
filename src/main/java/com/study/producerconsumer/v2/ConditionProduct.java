package main.java.com.study.producerconsumer.v2;

/**
 * @author: whb
 * @date: 2019/8/26 14:12
 * @description: 生产者
 */
public class ConditionProduct implements Runnable {

    private ConditionBuffer conditionBuffer;

    public ConditionProduct(ConditionBuffer conditionBuffer) {
        this.conditionBuffer = conditionBuffer;
    }

    @Override
    public void run() {
        int count = 1;
        for (; ; ) {
            String data = "a" + count;
            try {
                conditionBuffer.put(data);
                System.out.println("生产者生产了数据：" + data);
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
