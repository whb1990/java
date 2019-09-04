package main.java.com.study.designPatterns.facade.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 22:16
 * @description: 客户端调用
 */
public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doA();
        facade.doB();
        facade.doC();
    }
}
