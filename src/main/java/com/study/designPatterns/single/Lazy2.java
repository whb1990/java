package main.java.com.study.designPatterns.single;

/**
 * @author: whb
 * @date: 2019/6/13 9:44
 * @description: 懒汉式(线程安全，同步方法)【不推荐用】
 * 有点：解决了线程不安全问题，做个线程同步就可以了，于是就对getInstance()方法进行了线程同步。
 * 缺点：效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
 * 而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接return就行了。方法进行同步效率太低要改进。
 */
public class Lazy2 {

    private static Lazy2 lazy;

    private Lazy2() {
        System.out.println("懒汉式(线程安全，同步方法)...");
    }

    public static synchronized Lazy2 getInstance() {
        if (lazy == null) {
            lazy = new Lazy2();
        }
        return lazy;
    }
}
