package main.java.com.study.designPatterns.observer.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 21:39
 * @description: 微信公众号--具体被观察对象
 */
public class WeChatAccounts extends Publisher {
    /**
     * 公众号名称
     */
    private String name;

    public WeChatAccounts(String name) {
        this.name = name;
    }

    /**
     * 用于发布推送，当文章发布完毕时调用父类的通知所有订阅者方法
     *
     * @param articleName
     * @param content
     */
    public void publishArticles(String articleName, String content) {
        System.out.println(String.format("\n<%s>微信公众号 发布了一篇推送，文章名称为 <%s>，内容为 <%s> ", this.name, articleName, content));
        setPubStatus();
        notifySubscribers(this.name, articleName);
    }
}
