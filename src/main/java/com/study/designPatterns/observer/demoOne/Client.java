package main.java.com.study.designPatterns.observer.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 21:27
 * @description: 客户端调用
 */
public class Client {
    public static void main(String[] args) {
        // 被观察者
        ISubject<String> observable = new ConcreteSubject<>();
        // 观察者
        IObserver<String> observer = new ConcreteObserver<>();
        // 注册
        observable.attach(observer);
        // 通知
        observable.notify("hello");
    }
}
