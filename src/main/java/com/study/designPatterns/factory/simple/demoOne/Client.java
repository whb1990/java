package main.java.com.study.designPatterns.factory.simple.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 15:23
 * @description: 客户端
 */
public class Client {
    public static void main(String[] args) {
        ComputerFactory.createComputer("asus").startProduce();
    }
}
