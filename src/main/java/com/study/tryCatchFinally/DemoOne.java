package main.java.com.study.tryCatchFinally;

/**
 * @author: whb
 * @date: 2019/9/3 10:21
 * @description: try中有return，finally中没有return
 */
public class DemoOne {

    public static void main(String[] args) {
        System.out.println(testOne());
    }

    private static int testOne() {
        int num = 10;
        try {
            System.out.println("try...");
            return num += 100;
        } catch (Exception e) {
            System.out.println("catch...");
        } finally {
            if (num > 50) {
                System.out.println("num > 50 : " + num);
            }
            System.out.println("finally...");
        }
        return num;
    }
}
