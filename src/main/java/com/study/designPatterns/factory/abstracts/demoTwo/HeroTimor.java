package main.java.com.study.designPatterns.factory.abstracts.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 17:29
 * @description: 抽象角色-英雄：提莫
 */
public class HeroTimor implements Heros {

    @Override
    public void haveHero() {
        System.out.println("尊敬的召唤师，你已经拥有了迅捷斥候 - 提莫");
    }
}