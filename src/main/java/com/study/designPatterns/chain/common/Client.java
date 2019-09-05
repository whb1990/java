package main.java.com.study.designPatterns.chain.common;

/**
 * @author: whb
 * @date: 2019/9/5 15:20
 * @description: 客户端调用
 */
public class Client {
    public static void main(String[] args) {
        //先要组装职责链
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();

        h1.setSuccessor(h2);
        //然后提交请求
        h1.handleRequest();
    }
}
