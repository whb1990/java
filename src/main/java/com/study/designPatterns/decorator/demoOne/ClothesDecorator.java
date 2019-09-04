package main.java.com.study.designPatterns.decorator.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 17:11
 * @description: 定义衣服--抽象装饰器（Decorator），接收一个具体的Component，本身也是一个Component
 */
public abstract class ClothesDecorator implements IPerson {

    protected IPerson mPerson;

    /**
     * 构造方法：强制子类构造器必须传入一个IPerson
     */
    public ClothesDecorator(IPerson person) {
        this.mPerson = person;
    }

    @Override
    public void dress() {
        this.mPerson.dress();
    }
}
