package main.java.com.study.designPatterns.simpleFactoryPattern.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 15:17
 * @description: 具体产品类：联想电脑
 */
public class LenovoComputer extends Computer {

    @Override
    public void startProduce() {
        System.out.println("联想电脑启动生产");
    }
}
