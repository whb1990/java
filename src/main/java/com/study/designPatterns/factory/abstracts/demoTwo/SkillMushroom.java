package main.java.com.study.designPatterns.factory.abstracts.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 17:32
 * @description: 抽象角色-技能：蘑菇
 */
public class SkillMushroom implements Skills {

    @Override
    public void useSkill() {
        System.out.println("该英雄使用了技能 - 种蘑菇");
    }
}
