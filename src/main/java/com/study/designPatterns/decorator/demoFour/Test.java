package main.java.com.study.designPatterns.decorator.demoFour;

/**
 * @author: whb
 * @date: 2019/9/4 20:18
 * @description: 测试类
 */
public class Test {
    public static void main(String[] args) {
        //购买一个煎饼
        ABattercake aBattercake = new Battercake();
        System.out.println(aBattercake.getDesc() + ", 销售价格: " + aBattercake.cost());
        //购买一个加鸡蛋的煎饼
        aBattercake = new EggDecorator(aBattercake);
        System.out.println(aBattercake.getDesc() + ", 销售价格: " + aBattercake.cost());
        //购买一个加两个鸡蛋的煎饼
        aBattercake = new Battercake();
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new EggDecorator(aBattercake);
        System.out.println(aBattercake.getDesc() + ", 销售价格: " + aBattercake.cost());
    }
}
