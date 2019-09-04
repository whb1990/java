package main.java.com.study.designPatterns.decorator.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 17:17
 * @description: 外套装饰器
 */
public class OvercoatDecorator extends ClothesDecorator {

    /**
     * 构造方法：强制子类构造器必须传入一个IPerson
     *
     * @param person
     */
    public OvercoatDecorator(IPerson person) {
        super(person);
    }

    @Override
    public void dress() {
        super.dress();
        this.dressOvercoat();
    }

    /**
     * 穿外套
     */
    private void dressOvercoat() {
        System.out.println("穿上外套了！");
    }
}
