package main.java.com.study.designPatterns.factory.method.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 16:25
 * @description: 具体工厂类A，定义创建具体产品的实例方法
 */
public class FactoryA extends Factory {

    @Override
    public Product manuFacture() {
        return new ProductA();
    }
}
