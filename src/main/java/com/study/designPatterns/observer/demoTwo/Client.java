package main.java.com.study.designPatterns.observer.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/4 21:34
 * @description: 测试类
 */
public class Client {
    public static void main(String[] args) {
        //来一个闹钟
        IObservable<String> alarmClock = new AlarmClock();
        //我
        IObserver<String> me = new Me();
        //设置闹钟时间（注册监听）
        alarmClock.register(me);
        //闹钟响铃
        alarmClock.notify("ring! ring ! ring! time is up!");
    }
}
