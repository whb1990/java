package main.java.com.study.producerconsumer.v2;

/**
 * @author: whb
 * @date: 2019/8/26 15:43
 * @description: 条件队列实现生产者消费者模型
 */
public class ConditionTest {
    public static void main(String[] args) {
        ConditionBuffer conditionBuffer = new ConditionBuffer();
        ConditionProduct conditionProduct = new ConditionProduct(conditionBuffer);
        ConditionConsume conditionConsume = new ConditionConsume(conditionBuffer);
        new Thread(conditionProduct).start();
        new Thread(conditionConsume).start();
    }
}
