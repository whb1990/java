package main.java.com.study.designPatterns.factory.method.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 16:22
 * @description: 具体产品类A（继承抽象产品类），定义生产的具体产品
 */
public class ProductA extends Product {

    @Override
    public void show() {
        System.out.println("生产了产品A");
    }
}
