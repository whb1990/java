package main.java.com.study.designPatterns.observer.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/4 21:33
 * @description: 具体观察者
 */
public class Me implements IObserver<String> {
    @Override
    public void update(String event) {
        System.out.println("receive: " + event);
        System.out.println(this.getClass().getSimpleName() + ": time to wake up!");
    }
}