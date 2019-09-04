package main.java.com.study.designPatterns.decorator.demoFour;

/**
 * @author: whb
 * @date: 2019/9/4 20:15
 * @description: 煎饼类
 */
public class Battercake extends ABattercake {
    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
