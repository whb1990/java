package main.java.com.study.designPatterns.templateMethod.demoOne;

/**
 * @author: whb
 * @date: 2019/9/5 10:47
 * @description: 具体实现类B
 */
public class ConcreteClassB extends AbstractClass {
    @Override
    protected void step2() {
        System.out.println("ConcreateClassB:step2");
    }
}