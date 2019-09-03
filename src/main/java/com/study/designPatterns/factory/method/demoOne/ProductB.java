package main.java.com.study.designPatterns.factory.method.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 16:23
 * @description: 具体产品类B, 定义生产的具体产品
 */
public class ProductB extends Product {

    @Override
    public void show() {
        System.out.println("生产了产品B");
    }
}
