package main.java.com.study.designPatterns.factory.simple.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 15:30
 * @description: 定义具体英雄：艾希
 */
public class Ashe implements Heros {

    @Override
    public void buyHero() {
        System.out.println("召唤师，恭喜你获得了寒冰射手：艾希");
    }

    @Override
    public void useHeroSkill() {
        System.out.println("寒冰释放了技能：鹰击长空");
    }
}
