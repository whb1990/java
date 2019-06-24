package main.java.com.study.designPatterns.single;

/**
 * @author: whb
 * @date: 2019/6/13 9:46
 * @description: 懒汉式(线程安全 ， 同步代码块)【不可用】
 * 由于同步方法的同步效率太低，所以摒弃同步方法，改为同步产生实例化的的代码块。
 * 但是这种同步并不能起到线程同步的作用。假如一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。
 */
public class Lazy3 {

    private static volatile Lazy3 lazy;

    private Lazy3() {
        System.out.println("懒汉式(线程安全，同步代码块)...");
    }

    public static Lazy3 getInstance() {
        if (lazy == null) {
            synchronized (Lazy3.class) {
                lazy = new Lazy3();
            }
        }
        return lazy;
    }
}
