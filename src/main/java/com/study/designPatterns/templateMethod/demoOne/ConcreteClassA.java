package main.java.com.study.designPatterns.templateMethod.demoOne;

/**
 * @author: whb
 * @date: 2019/9/5 10:47
 * @description: 具体实现类A
 */
public class ConcreteClassA extends AbstractClass {
    @Override
    protected void step1() {
        System.out.println("ConcreateClassA:step1");
    }
}
