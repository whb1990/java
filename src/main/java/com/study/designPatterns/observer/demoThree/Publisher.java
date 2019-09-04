package main.java.com.study.designPatterns.observer.demoThree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2019/9/4 21:37
 * @description: 发布者--被观察对象，该类维护了一个订阅者列表，实现了订阅、取消订阅、通知所有订阅者等功能
 */
public class Publisher {
    /**
     * 订阅者集合
     */
    private List<Subscriber> subscribers;
    /**
     * 发布状态
     */
    private boolean pubStatus = false;

    public Publisher() {
        subscribers = new ArrayList<Subscriber>();
    }

    protected void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    protected void unsubscribe(Subscriber subscriber) {
        if (this.subscribers.contains(subscriber)) {
            this.subscribers.remove(subscriber);
        }
    }

    protected void notifySubscribers(String publisher, String articleName) {
        if (this.pubStatus == false) {
            return;
        }
        for (Subscriber subscriber : this.subscribers) {
            subscriber.receive(publisher, articleName);
        }
        this.clearPubStatus();
    }

    protected void setPubStatus() {
        this.pubStatus = true;
    }

    protected void clearPubStatus() {
        this.pubStatus = false;
    }
}
