package main.java.com.study.designPatterns.factory.method.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 16:39
 * @description: 客户端调用
 */
public class Client {

    public static void main(String[] args) {
        Heros arrowHero = new ArrowHeroFactory().productHeros();
        Heros swordsmanHero = new SwordsmanFactory().productHeros();
        Heros mageHero = new MageFactory().productHeros();

        arrowHero.buyHero();
        swordsmanHero.buyHero();
        mageHero.buyHero();
        System.out.println("---------------------------------------");

        arrowHero.useHeroSkill();
        swordsmanHero.useHeroSkill();
        mageHero.useHeroSkill();
    }
}
