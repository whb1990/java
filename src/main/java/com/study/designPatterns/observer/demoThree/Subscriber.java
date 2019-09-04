package main.java.com.study.designPatterns.observer.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 21:36
 * @description: 订阅者接口（观察者）
 */
public interface Subscriber {
    /**
     * 接收公众号推送通知
     *
     * @param publisher   公众号
     * @param articleName 文章
     * @return
     */
    int receive(String publisher, String articleName);
}
