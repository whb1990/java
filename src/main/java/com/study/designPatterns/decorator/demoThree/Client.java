package main.java.com.study.designPatterns.decorator.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 18:06
 * @description: 客户端调用
 */
public class Client {

    public static void main(String[] args) {
        Hero hero = new Timor("提莫队长");
        HeroSkill skill = new HeroSkill(hero);

        HeroSkill q = new Skill_Q(skill, "致盲吹箭");
        HeroSkill w = new Skill_W(skill, "小莫快跑");
        HeroSkill e = new Skill_E(skill, "毒性射击");
        HeroSkill r = new Skill_R(skill, "种蘑菇");
        //学习技能
        q.learnSkill();
        w.learnSkill();
        e.learnSkill();
        r.learnSkill();
        skill.learnSkill();
    }
}
