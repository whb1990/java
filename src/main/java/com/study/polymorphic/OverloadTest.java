package main.java.com.study.polymorphic;

/**
 * @author: whb
 * @date: 2019/9/25 15:29
 * @description: 方法重载测试
 */
public class OverloadTest {
    /**
     * 类定义
     */
    static abstract class Human {
    }

    /**
     * 继承自抽象类Human
     */
    static class Man extends Human {
    }

    static class Woman extends Man {
    }

    /**
     * 定义的重载方法（方法名相同，但参数列表不同（此处是类型不同））
     *
     * @param guy
     */
    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Man woman = new Woman();
        OverloadTest test = new OverloadTest();

        test.sayHello(man);
        test.sayHello(woman);

        /**
         * 1. 方法重载（`OverLoad`）的原理 = 静态分派 = 根据 变量的静态类型 确定执行（重载）哪个方法;
         * 2. 所以上述的方法执行时，是根据变量（`man`、`woman`）的静态类型（`Human`、`Man`）确定重载`sayHello()`中参数为`Human guy`、`Man guy`的方法,即`sayHello(Human guy)`、`sayHello(Man guy)` ;
         */
    }
}
