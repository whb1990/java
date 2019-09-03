package main.java.com.study.designPatterns.factory.abstracts.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 17:40
 * @description: 客户端调用
 */
public class Client {
    public static void main(String[] args) {
        HeroAndSkillFactory herosFactory = FactoryProduct.getFactoryByType("HerosFactory");

        Heros ashe = herosFactory.getHeros("Ashe");
        Heros masterYi = herosFactory.getHeros("MasterYi");
        Heros timor = herosFactory.getHeros("Timor");

        ashe.haveHero();
        masterYi.haveHero();
        timor.haveHero();

        System.out.println("=========================================");

        HeroAndSkillFactory skillFactory = FactoryProduct.getFactoryByType("SkillsFactory");

        Skills sword = skillFactory.getSkills("Sword");
        Skills arrow = skillFactory.getSkills("Arrow");
        Skills mushroom = skillFactory.getSkills("Mushroom");

        sword.useSkill();
        arrow.useSkill();
        mushroom.useSkill();
    }
}
