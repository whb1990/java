package main.java.com.study.designPatterns.factory.abstracts.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 17:13
 * @description: 具体产品类-容器B（继承抽象产品类）， 定义生产的具体产品
 */
public class ContainerProductB extends ContainerProduct {
    @Override
    public void show() {
        System.out.println("生产出了容器产品B...");
    }
}