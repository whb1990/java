package main.java.com.study.designPatterns.factory.method.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 16:38
 * @description: 定义剑客工厂
 */
public class SwordsmanFactory extends HeroFactory {

    @Override
    protected Heros productHeros() {
        return new MasterYi();
    }
}
