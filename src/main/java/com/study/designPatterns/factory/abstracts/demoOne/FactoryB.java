package main.java.com.study.designPatterns.factory.abstracts.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 17:16
 * @description: 具体工厂类（继承抽象工厂类），定义创建对应具体产品实例的方法
 * B厂 - 生产模具+容器产品
 */
public class FactoryB extends Factory {

    @Override
    public AbstractProduct manufactureContainer() {
        return new ContainerProductB();
    }

    @Override
    public AbstractProduct manufactureMould() {
        return new MouldProductB();
    }
}