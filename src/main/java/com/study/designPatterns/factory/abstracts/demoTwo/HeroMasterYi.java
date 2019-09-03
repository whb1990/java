package main.java.com.study.designPatterns.factory.abstracts.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 17:28
 * @description: 抽象角色-英雄：无极剑圣易大师
 */
public class HeroMasterYi implements Heros {

    @Override
    public void haveHero() {
        System.out.println("尊敬的召唤师，你已经拥有了无极剑圣 - 易大师");
    }
}