package main.java.com.study.designPatterns.proxy.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 21:46
 * @description: 静态代理客户端调用
 */
public class StaticProxyClient {

    public static void main(String[] args) {
        Subject proxy = new ProxySubject(new RealSubject());
        proxy.buyMac();
    }
}
