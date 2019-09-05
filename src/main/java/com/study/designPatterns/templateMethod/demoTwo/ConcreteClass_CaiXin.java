package main.java.com.study.designPatterns.templateMethod.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/5 11:01
 * @description: 蒜蓉炒菜心
 */
public class ConcreteClass_CaiXin extends AbstractClass {
    @Override
    public void pourVegetable() {
        System.out.println("下锅的蔬菜是菜心");
    }

    @Override
    public void pourSauce() {
        System.out.println("下锅的酱料是蒜蓉");
    }
}