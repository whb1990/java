package main.java.com.study.designPatterns.factory.method.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 16:37
 * @description: 定义法师工厂
 */
public class MageFactory extends HeroFactory {

    @Override
    protected Heros productHeros() {
        return new Timor();
    }
}
