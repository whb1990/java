package main.java.com.study.designPatterns.proxy.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 22:22
 * @description: 静态代理测试
 */
public class TestStaticProxy {

    public static void main(String[] args) {
        //实例化代理类
        Scalpers scalpersProxy = new Scalpers(new Person());
        //调用代理类的方法
        scalpersProxy.buyTicket();
    }
}
