package main.java.com.study.designPatterns.observer.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 21:24
 * @description: 具体观察者
 */
public class ConcreteObserver<E> implements IObserver<E> {

    @Override
    public void update(E event) {
        System.out.println("receive event：" + event);
    }
}
