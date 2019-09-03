package main.java.com.study.designPatterns.factory.abstracts.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 17:14
 * @description: 具体产品类--模具A（继承抽象产品类）， 定义生产的具体产品
 */
public class MouldProductA extends MouldProduct {

    @Override
    public void show() {
        System.out.println("生产出了模具产品A...");
    }
}