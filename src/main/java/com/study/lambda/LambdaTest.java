package main.java.com.study.lambda;

import org.junit.Test;

/**
 * @author: whb
 * @date: 2019/7/10 15:32
 * @description: 包含属性为函数式接口的类
 */
public class LambdaTest {
    /**
     * 通过匿名内部类实现无参无返回值
     */
    InterfaceWithNoParam interfaceWithNoParam = new InterfaceWithNoParam() {
        @Override
        public void run() {
            System.out.println("通过匿名内部类实现无参无返回值的run()...");
        }
    };
    /**
     * 通过Lambda表达式实现无参无返回值。空括号表示无参
     */
    InterfaceWithNoParam param = () -> System.out.println("通过Lambda表达式实现无参无返回值的run()...");

    /**
     * 通过匿名内部类实现无参有返回值的接口
     */
    InterfaceUnVoidWithParam interfaceUnVoidWithParam = new InterfaceUnVoidWithParam() {
        @Override
        public String run() {
            return "通过匿名内部类实现无参有返回值的接口run()...";
        }
    };

    /**
     * 通过Lambda表达式实现无参有返回值的接口
     */
    InterfaceUnVoidWithParam interfaceUnVoidWithParam2 = () -> "通过Lambda表达式实现无参有返回值的run()...";

    /**
     * 匿名内部类实现有参有返回值的接口
     */
    InterfaceWithParam interfaceWithParam = new InterfaceWithParam() {
        @Override
        public String run(Integer integer) {
            return integer == null ? "empty" : integer.toString();
        }
    };

    /**
     * 通过Lambda表达式实现有参有返回值的接口
     */
    InterfaceWithParam interfaceWithParam2 = (Integer integer) -> integer.toString();

    @Test
    public void test() {
        this.interfaceWithNoParam.run();
        this.param.run();
        System.out.println();
        System.out.println(this.interfaceUnVoidWithParam.run());
        System.out.println(this.interfaceUnVoidWithParam2.run());
        System.out.println();
        System.out.println("通过匿名内部类实现有参有返回值的接口，您输入的值是：" + this.interfaceWithParam.run(1));
        System.out.println("通过Lambda表达式实现有参有返回值的接口，您输入的值是：" + this.interfaceWithParam2.run(2));
    }
}
