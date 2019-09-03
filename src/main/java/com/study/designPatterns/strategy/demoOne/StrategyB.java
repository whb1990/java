package main.java.com.study.designPatterns.strategy.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 20:16
 * @description: 定义具体策略角色：中秋促销活动
 */
public class StrategyB extends Strategy {

    @Override
    public void show() {
        System.out.println("为中秋节准备的促销活动B");
    }
}
