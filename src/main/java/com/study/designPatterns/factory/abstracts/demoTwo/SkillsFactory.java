package main.java.com.study.designPatterns.factory.abstracts.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 17:36
 * @description: 具体工厂-技能
 */
public class SkillsFactory extends HeroAndSkillFactory {

    @Override
    public Heros getHeros(String heroType) {
        return null;
    }

    @Override
    public Skills getSkills(String skillType) {
        Skills skills = null;
        switch (skillType) {
            case "Sword":
                skills = new SkillSword();
                break;
            case "Arrow":
                skills = new SkillArrow();
                break;
            case "Mushroom":
                skills = new SkillMushroom();
                break;
        }
        return skills;
    }
}
