package main.java.com.study.designPatterns.observer.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 21:39
 * @description: 测试类
 */
public class Test {
    public static void main(String[] args) {
        WeChatAccounts accounts = new WeChatAccounts("小博爷");

        WeChatClient user1 = new WeChatClient("大嘴张三");
        WeChatClient user2 = new WeChatClient("肥头李四");
        WeChatClient user3 = new WeChatClient("钻石王五");

        accounts.subscribe(user1);
        accounts.subscribe(user2);
        accounts.subscribe(user3);

        accounts.publishArticles("设计模式 | 观察者模式及典型应用", "观察者模式的内容...");

        accounts.unsubscribe(user1);
        accounts.publishArticles("设计模式 | 单例模式及典型应用", "单例模式的内容....");
    }
}
