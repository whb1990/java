package main.java.com.study.designPatterns.proxy.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 22:29
 * @description: 测试动态代理
 */
public class TestDynamicProxy {

    public static void main(String[] args) {
        //动态代理需要传入接口对象，也就是接口子类
        BuyTicket buyTicket = new Scalpers(new Person());
        //将接口对象传进代理类使用代理方法
        BuyTicket scalpers = (BuyTicket) new UseProxy(buyTicket).getProxyInstance();
        //执行代理对象的方法
        scalpers.buyTicket();
    }
}
