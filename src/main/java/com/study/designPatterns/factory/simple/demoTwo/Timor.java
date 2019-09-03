package main.java.com.study.designPatterns.factory.simple.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 15:33
 * @description: 定义具体英雄：提莫
 */
public class Timor implements Heros {

    @Override
    public void buyHero() {
        System.out.println("召唤师，恭喜你获得了迅捷斥候：提莫");
    }

    @Override
    public void useHeroSkill() {
        System.out.println("提莫释放了技能：毒性攻击");
    }
}
