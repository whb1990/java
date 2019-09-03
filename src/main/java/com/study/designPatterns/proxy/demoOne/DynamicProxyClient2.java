package main.java.com.study.designPatterns.proxy.demoOne;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author: whb
 * @date: 2019/9/3 22:13
 * @description: 动态代理测试2
 */
public class DynamicProxyClient2 {
    public static void main(String[] args) {

        //代理对象
        Subject subject = new ProxySubject(new RealSubject());
        //实现InvocationHandler接口的类，将代理对象传进去
        InvocationHandler handler = new DynamicHandle(subject);
        //进行动态代理
        Subject prox = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),
                handler);
        //接口调用
        prox.buyMac();
    }
}
