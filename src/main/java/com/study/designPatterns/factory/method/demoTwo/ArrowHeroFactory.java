package main.java.com.study.designPatterns.factory.method.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 16:37
 * @description: 定义射手工厂
 */
public class ArrowHeroFactory extends HeroFactory {

    @Override
    protected Heros productHeros() {
        return new Ashe();
    }
}
