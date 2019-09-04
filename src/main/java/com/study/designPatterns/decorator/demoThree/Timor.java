package main.java.com.study.designPatterns.decorator.demoThree;

import java.util.concurrent.TimeUnit;

/**
 * @author: whb
 * @date: 2019/9/4 18:02
 * @description: 实例化提莫
 */
public class Timor implements Hero {

    /**
     * 英雄名称
     */
    private String name;

    public Timor(String name) {
        this.name = name;
    }

    @Override
    public void learnSkill() {
        System.out.println(name + " 学习了以上技能！");
    }
}
