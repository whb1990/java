package main.java.com.study.designPatterns.single;

/**
 * @author: whb
 * @date: 2019/6/13 9:40
 * @description: 饿汉式（静态常量）【可用】
 * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 */
public class Hungry {

    //自有永久的对象
    private static final Hungry hungry = new Hungry();

    //构造器私有化
    private Hungry() {
        System.out.println("饿汉式（静态常量）...");
    }

    public static Hungry getInstance() {
        return hungry;
    }
}
