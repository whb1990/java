package main.java.com.study.designPatterns.single;

/**
 * @author: whb
 * @date: 2019/6/13 10:09
 * @description: 饿汉式（静态代码块）【可用】
 * 将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。
 * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 */
public class Hungry2 {

    private static Hungry2 hungry2;

    static {
        hungry2 = new Hungry2();
    }

    private Hungry2() {
        System.out.println("饿汉式（静态代码块）...");
    }

    public static Hungry2 getInstance() {
        return hungry2;
    }
}
