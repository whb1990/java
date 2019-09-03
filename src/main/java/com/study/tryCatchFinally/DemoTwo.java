package main.java.com.study.tryCatchFinally;

/**
 * @author: whb
 * @date: 2019/9/3 10:27
 * @description: try和finally中均有return
 */
public class DemoTwo {

    public static void main(String[] args) {
        System.out.println(testTwo());
    }

    private static int testTwo() {
        int num = 10;
        try {
            System.out.println("try...");
            return num += 100;
        } catch (Exception e) {
            System.out.println("catch error...");
        } finally {
            if (num > 50) {
                System.out.println("num > 50 : " + num);
            }
            System.out.println("finally...");
            num = 100;
            return num;
        }
    }
}
