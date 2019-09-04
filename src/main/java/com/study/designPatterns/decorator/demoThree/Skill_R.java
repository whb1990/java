package main.java.com.study.designPatterns.decorator.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 18:06
 * @description: R技能
 */
public class Skill_R extends HeroSkill {
    /**
     * 技能名称
     */
    private String skillName;

    public Skill_R(Hero timor, String skillName) {
        super(timor);
        this.skillName = skillName;
    }

    @Override
    public void learnSkill() {
        System.out.println("学习了R技能：" + skillName);
        //super.learnSkill();
    }
}

