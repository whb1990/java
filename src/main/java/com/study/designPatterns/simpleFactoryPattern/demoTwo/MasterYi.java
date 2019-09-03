package main.java.com.study.designPatterns.simpleFactoryPattern.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 15:31
 * @description: 定义具体英雄：剑圣易大师
 */
public class MasterYi implements Heros {

    @Override
    public void buyHero() {
        System.out.println("召唤师，恭喜你获得了无极剑圣：易大师");
    }

    @Override
    public void useHeroSkill() {
        System.out.println("剑圣释放了技能：无极剑道");
    }
}
