package main.java.com.study.designPatterns.observer.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/4 21:32
 * @description: 被观察者
 */
public interface IObservable<E> {
    /**
     * 注册
     *
     * @param observer
     * @return
     */
    boolean register(IObserver<E> observer);

    /**
     * 取消注册
     *
     * @param observer
     * @return
     */
    boolean unRegister(IObserver<E> observer);

    /**
     * 通知
     *
     * @param event
     */
    void notify(E event);
}
