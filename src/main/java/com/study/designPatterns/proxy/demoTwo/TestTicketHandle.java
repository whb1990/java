package main.java.com.study.designPatterns.proxy.demoTwo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author: whb
 * @date: 2019/9/3 22:54
 * @description: 动态代理测试2
 */
public class TestTicketHandle {

    public static void main(String[] args) {
        //代理对象
        BuyTicket buyTicket = new Scalpers(new Person());
        //实现InvocationHandler接口的类，将代理对象传进去
        InvocationHandler hanle = new UseHandle(buyTicket);
        //进行动态代理
        BuyTicket scalper = (BuyTicket) Proxy.newProxyInstance(buyTicket.getClass().getClassLoader(),
                buyTicket.getClass().getInterfaces(),
                hanle);
        //调用代理类接口
        scalper.buyTicket();
    }
}
