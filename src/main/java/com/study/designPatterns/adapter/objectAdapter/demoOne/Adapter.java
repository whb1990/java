package main.java.com.study.designPatterns.adapter.objectAdapter.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 15:12
 * @description: 适配器类（Adapter）（不适用继承而是委派）
 */
public class Adapter implements Target {
    /**
     * 直接关联被适配类
     */
    private Adaptee adaptee;

    /**
     * 可以通过构造函数传入具体需要适配的被适配类对象
     */
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        //这里使用委托的方式完成适配
        this.adaptee.specificRequest();
    }
}
