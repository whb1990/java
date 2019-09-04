package main.java.com.study.designPatterns.decorator.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 17:09
 * @description: 客户端调用
 */
public class Client {

    public static void main(String[] args) {
        IPerson person = new Man();
        person.dress();

        System.out.println("----------------------");
        System.out.println("增加裤子装饰器");
        person = new TrousersDecorator(person);
        person.dress();

        System.out.println("----------------------");
        System.out.println("再增加内衣装饰器");
        person = new UnderClothesDecorator(person);
        person.dress();

        System.out.println("----------------------");
        System.out.println("再增加外套装饰器");
        person = new OvercoatDecorator(person);
        person.dress();
    }
}
