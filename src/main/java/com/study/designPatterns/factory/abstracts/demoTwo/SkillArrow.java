package main.java.com.study.designPatterns.factory.abstracts.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 17:33
 * @description: 抽象角色-技能：射击
 */
public class SkillArrow implements Skills {

    @Override
    public void useSkill() {
        System.out.println("该英雄使用了技能 - 鹰击长空");
    }
}