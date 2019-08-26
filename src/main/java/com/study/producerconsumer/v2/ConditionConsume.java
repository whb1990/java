package main.java.com.study.producerconsumer.v2;

/**
 * @author: whb
 * @date: 2019/8/26 14:14
 * @description: 消费者
 */
public class ConditionConsume implements Runnable {

    private ConditionBuffer conditionBuffer;

    public ConditionConsume(ConditionBuffer conditionBuffer) {
        this.conditionBuffer = conditionBuffer;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                System.out.println("消费者消费了数据：" + conditionBuffer.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
