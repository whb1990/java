package main.java.com.study.designPatterns.strategy.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 20:18
 * @description: 定义环境角色：用于连接上下文，把促销活动推销给用户，这里可以理解为销售员
 */
public class SalesMan {
    //持有抽象策略角色的引用
    private Strategy strategy;

    /**
     * 生成销售员实例时告诉销售员什么节日（构造方法）
     * 使得让销售员根据传入的参数（节日）选择促销活动（这里使用一个简单的工厂模式）
     */
    public SalesMan(String festival) {
        switch (festival) {
            //春节就使用春节促销活动
            case "A":
                strategy = new StrategyA();
                break;
            //中秋节就使用中秋节促销活动
            case "B":
                strategy = new StrategyB();
                break;
            //圣诞节就使用圣诞节促销活动
            case "C":
                strategy = new StrategyC();
                break;
        }
    }

    /**
     * 向客户展示促销活动
     */
    public void salesManShow() {
        strategy.show();
    }
}
