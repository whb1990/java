package main.java.com.study.designPatterns.decorator.demoFour;

/**
 * @author: whb
 * @date: 2019/9/4 20:15
 * @description: 煎饼抽象类
 */
public abstract class ABattercake {
    /**
     * 描述
     *
     * @return
     */
    protected abstract String getDesc();

    /**
     * 花费
     *
     * @return
     */
    protected abstract int cost();
}
