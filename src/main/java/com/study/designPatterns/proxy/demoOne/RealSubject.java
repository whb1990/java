package main.java.com.study.designPatterns.proxy.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 21:43
 * @description: 真实对象类
 */
public class RealSubject implements Subject {

    @Override
    public void buyMac() {
        System.out.println("买一台mac本...");
    }
}
