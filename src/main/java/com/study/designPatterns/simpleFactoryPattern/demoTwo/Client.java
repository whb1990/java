package main.java.com.study.designPatterns.simpleFactoryPattern.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 15:37
 * @description: 客户端调用
 */
public class Client {

    public static void main(String[] args) {
        HeroFactory heroFactory = new HeroFactory();
        Heros ashe = heroFactory.getDifferentHero("Ashe");
        ashe.buyHero();
        ashe.useHeroSkill();
        System.out.println("-----------------------------------------");
        Heros masterYi = heroFactory.getDifferentHero("MasterYi");
        masterYi.buyHero();
        masterYi.useHeroSkill();
    }
}
