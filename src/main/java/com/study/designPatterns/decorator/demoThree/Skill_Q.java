package main.java.com.study.designPatterns.decorator.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 18:03
 * @description: Q技能
 */
public class Skill_Q extends HeroSkill {
    /**
     * 技能名称
     */
    private String skillName;

    public Skill_Q(Hero timor, String skillName) {
        super(timor);
        this.skillName = skillName;
    }

    @Override
    public void learnSkill() {
        System.out.println("学习了Q技能：" + skillName);
        //super.learnSkill();
    }
}
