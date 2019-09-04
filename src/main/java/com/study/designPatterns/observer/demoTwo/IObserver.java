package main.java.com.study.designPatterns.observer.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/4 21:31
 * @description: 抽象观察者
 */
public interface IObserver<E> {
    /**
     * 更新数据
     */
    void update(E event);
}


