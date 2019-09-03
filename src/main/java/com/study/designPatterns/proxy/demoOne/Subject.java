package main.java.com.study.designPatterns.proxy.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 21:42
 * @description: 抽象对象接口，声明你（真实对象）需要让代购（代理对象）帮忙做的事（买Mac）
 */
public interface Subject {

    /**
     * 买mac本
     */
    public void buyMac();
}
