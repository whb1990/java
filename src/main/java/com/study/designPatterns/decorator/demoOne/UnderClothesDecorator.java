package main.java.com.study.designPatterns.decorator.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 17:15
 * @description: 内衣装饰器
 */
public class UnderClothesDecorator extends ClothesDecorator {

    /**
     * 构造方法：强制子类构造器必须传入一个IPerson
     *
     * @param person
     */
    public UnderClothesDecorator(IPerson person) {
        super(person);
    }

    @Override
    public void dress() {
        super.dress();
        this.dressUnderClothes();
    }

    /**
     * 穿内衣
     */
    private void dressUnderClothes() {
        System.out.println("穿上内衣了！");
    }
}
