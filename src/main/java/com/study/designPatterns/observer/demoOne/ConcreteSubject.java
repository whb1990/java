package main.java.com.study.designPatterns.observer.demoOne;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2019/9/4 21:25
 * @description: 具体主题者
 */
public class ConcreteSubject<E> implements ISubject<E> {
    /**
     * 观察者集合
     */
    private List<IObserver<E>> mObservers = new ArrayList<>();

    @Override
    public boolean attach(IObserver<E> observer) {
        return !this.mObservers.contains(observer) && this.mObservers.add(observer);
    }

    @Override
    public boolean detach(IObserver<E> observer) {
        return this.mObservers.remove(observer);
    }

    @Override
    public void notify(E event) {
        for (IObserver<E> observer : this.mObservers) {
            observer.update(event);
        }
    }
}
