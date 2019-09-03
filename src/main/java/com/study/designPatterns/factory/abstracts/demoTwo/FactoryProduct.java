package main.java.com.study.designPatterns.factory.abstracts.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 17:38
 * @description: 抽象工厂生产区，这个类主要是用来获取工厂的
 */
public class FactoryProduct {
    /**
     * 获取指定的工厂类
     *
     * @param factoryType
     * @return
     */
    public static HeroAndSkillFactory getFactoryByType(String factoryType) {
        if ("HerosFactory".equals(factoryType)) {
            return new HerosFactory();
        } else if ("SkillsFactory".equals(factoryType)) {
            return new SkillsFactory();
        }
        return null;
    }
}
