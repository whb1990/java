package main.java.com.study.designPatterns.single;

/**
 * @author: whb
 * @date: 2019/6/13 9:49
 * @description: 单例模式测试
 */
public class singleTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                /**
                 * 饿汉式（静态常量）【可用】
                 */
                //Hungry hungry = Hungry.getInstance();
                //System.out.println("第" + (finalI + 1) + "次获得的hungry对象的hashCode：" + hungry.hashCode());

                /**
                 * 饿汉式（静态代码块）【可用】
                 */
                //Hungry2 hungry2 = Hungry2.getInstance();
                //System.out.println("第" + (finalI + 1) + "次获得的hungry2对象的hashCode：" + hungry2.hashCode());

                /**
                 * 懒汉式（线程不安全）【不可用】
                 */
                //Lazy lazy = Lazy.getInstance();
                //System.out.println("第" + (finalI + 1) + "次获得的lazy对象的hashCode：" + lazy.hashCode());

                /**
                 * 懒汉式(线程安全，同步方法)【不推荐用】
                 */
                //Lazy2 lazy2 = Lazy2.getInstance();
                //System.out.println("第" + (finalI + 1) + "次获得的lazy2对象的hashCode：" + lazy2.hashCode());

                /**
                 * 懒汉式(线程安全，同步代码块)【不可用】
                 */
                //Lazy3 lazy3 = Lazy3.getInstance();
                //System.out.println("第" + (finalI + 1) + "次获得的lazy3对象的hashCode：" + lazy3.hashCode());

                /**
                 * 双重检查【推荐用】
                 */
                //DoubleCheck doubleCheck = DoubleCheck.getInstance();
                //System.out.println("第" + (finalI + 1) + "次获得的doubleCheck对象的hashCode：" + doubleCheck.hashCode());

                /**
                 * 静态内部类【推荐用】
                 */
                //StaticInnerClass staticInnerClass = StaticInnerClass.getInstance();
                //System.out.println("第" + (finalI + 1) + "次获得的staticInnerClass对象的hashCode：" + staticInnerClass.hashCode());

                /**
                 * 枚举【推荐用】
                 */
                EnumSingleton enumSingleton = EnumSingleton.Instance;
                System.out.println("第" + (finalI + 1) + "次获得的enumSingleton对象的hashCode：" + enumSingleton.hashCode());
            }).start();
        }
    }
}
