package main.java.com.study.designPatterns.decorator.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 18:00
 * @description: 英雄的技能（抽象的技能 Q W E R具体继承即可）
 */
public class HeroSkill implements Hero {

    /**
     * 将顶层的英雄接口以构造传递进来
     */
    private Hero timor;

    public HeroSkill(Hero timor) {
        this.timor = timor;
    }

    @Override
    public void learnSkill() {
        timor.learnSkill();
    }
}
