package main.java.com.study.designPatterns.factory.method.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 16:35
 * @description: 工厂方法模式：LOL商城
 */
public abstract class HeroFactory {
    /**
     * 定义抽象方法，让子类完成具体的操作
     */
    protected abstract Heros productHeros();
}
