package main.java.com.study.designPatterns.proxy.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 21:57
 * @description: 动态代理客户端调用
 */
public class DynamicProxyClient {

    public static void main(String[] args) {

        //动态代理需要传入接口对象，也就是接口子类
        Subject subject = new ProxySubject(new RealSubject());
        //将接口库对象传进代理类，使用代理方法
        Subject proxy = (Subject) new DynamicProxy(subject).getProxyInstance();
        //执行方法【代理对象】
        proxy.buyMac();
    }
}
