package main.java.com.study.designPatterns.decorator.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 18:05
 * @description: W技能
 */
public class Skill_W extends HeroSkill {
    /**
     * 技能名称
     */
    private String skillName;

    public Skill_W(Hero timor, String skillName) {
        super(timor);
        this.skillName = skillName;
    }

    @Override
    public void learnSkill() {
        System.out.println("学习了W技能：" + skillName);
        //super.learnSkill();
    }
}
