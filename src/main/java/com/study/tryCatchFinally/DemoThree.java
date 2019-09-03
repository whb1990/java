package main.java.com.study.tryCatchFinally;

/**
 * @author: whb
 * @date: 2019/9/3 10:30
 * @description: finally中改变返回值num
 */
public class DemoThree {

    public static void main(String[] args) {
        System.out.println(testThree());
    }

    private static int testThree() {
        int num = 10;
        try {
            System.out.println("try...");
            return num;
        } catch (Exception e) {
            System.out.println("catch error...");
        } finally {
            if (num > 20) {
                System.out.println("num > 20 : " + num);
            }
            System.out.println("finally");
            num = 100;
        }
        return num;
    }
}
