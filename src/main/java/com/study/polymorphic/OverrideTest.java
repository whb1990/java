package main.java.com.study.polymorphic;

/**
 * @author: whb
 * @date: 2019/9/25 15:42
 * @description: 方法重写测试类
 */
public class OverrideTest {
    // 测试代码
    public static void main(String[] args) {
        // 情况1
        Human man = new Man();
        man.sayHello();

        // 情况2
        man = new Woman();
        man.sayHello();
    }

    /**
     * 定义父类
     */
    static class Human {
        public void sayHello() {
            System.out.println("Human say hello");
        }
    }

    /**
     * 继承类Human 并 重写sayHello()
     */
    static class Man extends Human {
        @Override
        public void sayHello() {
            System.out.println("man say hello");
        }
    }

    static class Woman extends Human {
        @Override
        public void sayHello() {
            System.out.println("woman say hello");
        }
    }
}

