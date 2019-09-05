package main.java.com.study.designPatterns.templateMethod.demoOne;

/**
 * @author: whb
 * @date: 2019/9/5 10:48
 * @description: 测试类
 */
public class Client {
    public static void main(String[] args) {
        AbstractClass abc = new ConcreteClassA();
        abc.templateMehthod();
        abc = new ConcreteClassB();
        abc.templateMehthod();
    }
}
