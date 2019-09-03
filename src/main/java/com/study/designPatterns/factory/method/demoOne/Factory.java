package main.java.com.study.designPatterns.factory.method.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 16:20
 * @description: 抽象工厂类，定义具体工厂的公共接口
 */
public abstract class Factory {
    /**
     * 生产产品
     *
     * @return
     */
    public abstract Product manuFacture();
}
