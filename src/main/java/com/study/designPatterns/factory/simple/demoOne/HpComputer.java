package main.java.com.study.designPatterns.factory.simple.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 15:18
 * @description: 具体产品类：惠普电脑
 */
public class HpComputer extends Computer {
    @Override
    public void startProduce() {
        System.out.println("惠普电脑启动生产");
    }
}
