package main.java.com.study.designPatterns.factory.abstracts.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 17:31
 * @description: 抽象角色-技能：剑道
 */
public class SkillSword implements Skills {

    @Override
    public void useSkill() {
        System.out.println("该英雄使用了技能 - 无极剑道");
    }
}
