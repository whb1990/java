package main.java.com.study.designPatterns.factory.abstracts.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 17:27
 * @description: 抽象角色-英雄：寒冰射手艾希
 */
public class HeroAshe implements Heros {

    @Override
    public void haveHero() {
        System.out.println("尊敬的召唤师，你已经拥有了寒冰射手 - 艾希");
    }
}
