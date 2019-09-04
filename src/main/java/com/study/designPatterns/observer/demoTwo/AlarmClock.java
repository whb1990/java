package main.java.com.study.designPatterns.observer.demoTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2019/9/4 21:34
 * @description: 闹钟--具体被观察者
 */
public class AlarmClock implements IObservable<String> {
    private List<IObserver<String>> mObservers = new ArrayList<>();

    @Override
    public boolean register(IObserver<String> observer) {
        return !this.mObservers.contains(observer) && this.mObservers.add(observer);
    }

    @Override
    public boolean unRegister(IObserver<String> observer) {
        return this.mObservers.remove(observer);
    }

    @Override
    public void notify(String event) {
        for (IObserver<String> observer : this.mObservers) {
            observer.update(event);
        }
    }
}
