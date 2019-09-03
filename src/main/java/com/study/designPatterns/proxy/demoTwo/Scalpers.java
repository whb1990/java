package main.java.com.study.designPatterns.proxy.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 22:19
 * @description: 黄牛：代理对象
 */
public class Scalpers implements BuyTicket {

    /**
     * 引用真实对象
     */
    private Person person;

    public Scalpers(Person person) {
        this.person = person;
    }

    @Override
    public void buyTicket() {
        person.buyTicket();
        System.out.println("黄牛：购买车票请提供你的基本信息...");
        System.out.println("------------用户准备信息中...---------------");
        person.personData();
        System.out.println("黄牛：乘车人信息已收到，我帮你刷票，记得五星好评呦~");
    }
}
