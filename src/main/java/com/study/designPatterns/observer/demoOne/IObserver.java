package main.java.com.study.designPatterns.observer.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 21:18
 * @description: 抽象观察者
 */
public interface IObserver<E> {
    /**
     * 更新数据
     */
    void update(E event);
}

