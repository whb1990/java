package main.java.com.study.designPatterns.factory.abstracts.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 17:16
 * @description: 客户端调用
 */
public class Client {
    public static void main(String[] args) {
        FactoryA mFactoryA = new FactoryA();
        FactoryB mFactoryB = new FactoryB();
        //A厂当地客户需要容器产品A
        mFactoryA.manufactureContainer().show();
        //A厂当地客户需要模具产品A
        mFactoryA.manufactureMould().show();

        //B厂当地客户需要容器产品B
        mFactoryB.manufactureContainer().show();
        //B厂当地客户需要模具产品B
        mFactoryB.manufactureMould().show();

    }
}
