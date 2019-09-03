package main.java.com.study.designPatterns.factory.method.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 16:26
 * @description: 客户端调用
 */
public class Client {

    public static void main(String[] args) {
        //客户要产品A
        FactoryA factoryA = new FactoryA();
        factoryA.manuFacture().show();
        //客户要产品B
        FactoryB factoryB = new FactoryB();
        factoryB.manuFacture().show();
    }
}
