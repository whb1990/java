package main.java.com.study.designPatterns.templateMethod.demoOne;

/**
 * @author: whb
 * @date: 2019/9/5 10:46
 * @description: 抽象模板类，定义了一套算法框架/流程；
 */
public abstract class AbstractClass {
    protected void step1() {
        System.out.println("AbstractClass:step1");
    }

    protected void step2() {
        System.out.println("AbstractClass:step2");
    }

    protected void step3() {
        System.out.println("AbstractClass:step3");
    }

    /**
     * 固定算法，声明为final方法，避免子类覆写
     */
    public final void templateMehthod() {
        this.step1();
        this.step2();
        this.step3();
    }
}
