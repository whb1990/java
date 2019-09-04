package main.java.com.study.designPatterns.decorator.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 17:13
 * @description: 裤子装饰器-具体装饰器（ConcreteDecorator）
 */
public class TrousersDecorator extends ClothesDecorator {

    /**
     * 构造方法：强制子类构造器必须传入一个IPerson
     *
     * @param person
     */
    public TrousersDecorator(IPerson person) {
        super(person);
    }

    @Override
    public void dress() {
        super.dress();
        this.dressTrousers();
    }

    /**
     * 穿裤子
     */
    private void dressTrousers() {
        System.out.println("穿上裤子了！");
    }
}
