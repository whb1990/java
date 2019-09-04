package main.java.com.study.designPatterns.decorator.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 17:19
 * @description: Client.java中客户是为new Man()这个IPerson一件一件的进行衣服试穿，太浪费时间了，完全可以使用装饰器嵌套（因为装饰器接收一个IPerson，而自己同时也是一个IPerson，因此完全支持嵌套）模式，这样一次性就穿完
 */
public class Client2 {
    public static void main(String[] args) {
        IPerson person = new OvercoatDecorator(new UnderClothesDecorator(new TrousersDecorator(new Man())));
        person.dress();
    }
}
