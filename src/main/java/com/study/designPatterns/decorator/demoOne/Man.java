package main.java.com.study.designPatterns.decorator.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 17:10
 * @description: 定义男人--具体组件（ConcreteComponent），即被修饰者
 */
public class Man implements IPerson {

    @Override
    public void dress() {
        System.out.println("穿了内裤！");
    }
}
