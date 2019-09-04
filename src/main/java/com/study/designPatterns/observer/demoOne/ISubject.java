package main.java.com.study.designPatterns.observer.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 21:19
 * @description: 抽象主题
 */
public interface ISubject<E> {
    /**
     * 注册
     *
     * @param observer
     * @return
     */
    boolean attach(IObserver<E> observer);

    /**
     * 取消注册
     *
     * @param observer
     * @return
     */
    boolean detach(IObserver<E> observer);

    /**
     * 通知
     *
     * @param event
     */
    void notify(E event);
}
