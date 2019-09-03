package main.java.com.study.tryCatchFinally;

/**
 * @author: whb
 * @date: 2019/9/3 10:34
 * @description: 将num的值包装在Num类中
 */
public class DemoFour {
    public static void main(String[] args) {
        System.out.println(test().num);
    }

    private static Num test() {
        Num number = new Num();
        try {
            System.out.println("try");
            return number;
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            if (number.num > 20) {
                System.out.println("number.num > 20 : " + number.num);
            }
            System.out.println("finally");
            number.num = 100;
        }
        return number;
    }
}
class Num {
    public int num = 10;
}

