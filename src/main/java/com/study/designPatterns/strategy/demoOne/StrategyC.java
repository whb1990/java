package main.java.com.study.designPatterns.strategy.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 20:17
 * @description: 定义策略角色：圣诞促销活动
 */
public class StrategyC extends Strategy {

    @Override
    public void show() {
        System.out.println("为圣诞节准备的促销活动C");
    }
}
