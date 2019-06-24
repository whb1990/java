package main.java.com.study.designPatterns.single;

/**
 * @author: whb
 * @date: 2019/6/13 10:23
 * @description: 双重检查【推荐用】
 * 我们进行了两次if (doubleCheck == null)检查，这样就可以保证线程安全了。这样，实例化代码只用执行一次，后面再次访问时，判断if (doubleCheck == null)，直接return实例化对象。
 * 优点：线程安全；延迟加载；效率较高。
 */
public class DoubleCheck {

    private static volatile DoubleCheck doubleCheck;

    private DoubleCheck() {
        System.out.println("双重检查...");
    }

    public static DoubleCheck getInstance() {
        if (doubleCheck == null) {
            synchronized (DoubleCheck.class) {
                if (doubleCheck == null) {
                    doubleCheck = new DoubleCheck();
                }
            }
        }
        return doubleCheck;
    }
}
