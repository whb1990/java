package main.java.com.study.lambda;

/**
 * @author: whb
 * @date: 2019/7/10 15:36
 * @description: 无参函数式接口
 * 函数式接口就是只显式声明一个抽象方法的接口。
 * 为保证方法数量不多不少，java8提供了一个专用注解@FunctionalInterface，这样，当接口中声明的抽象方法多于或少于一个时就会报错。
 */
@FunctionalInterface
public interface InterfaceWithNoParam {

    void run();
}
