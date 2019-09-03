package main.java.com.study.designPatterns.simpleFactoryPattern.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 15:18
 * @description: 具体产品类：华硕电脑
 */
public class AsusComputer extends Computer{
    @Override
    public void startProduce() {
        System.out.println("华硕电脑启动生产");
    }
}
