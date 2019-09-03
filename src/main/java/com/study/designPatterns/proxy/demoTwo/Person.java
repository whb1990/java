package main.java.com.study.designPatterns.proxy.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 22:16
 * @description: 真实对象：实际购票用户
 */
public class Person implements BuyTicket {

    @Override
    public void buyTicket() {
        System.out.println("你好，我想要买票...");
    }

    /**
     * 个人购票信息
     */
    public void personData() {
        System.out.println("你好，身份证号是：421081xxxxxxxxxxxx，电话：13896754221，行程范围：北京 - 上海");
    }
}
