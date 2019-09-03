package main.java.com.study.designPatterns.factory.abstracts.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 17:34
 * @description: 抽象工厂，让子类去实现
 */
public abstract class HeroAndSkillFactory {

    /**
     * 获取英雄
     */
    public abstract Heros getHeros(String heroType);

    /**
     * 使用技能
     */
    public abstract Skills getSkills(String skillType);
}
