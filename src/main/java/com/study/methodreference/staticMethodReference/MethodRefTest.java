package main.java.com.study.methodreference.staticMethodReference;

/**
 * @author: whb
 * @date: 2019/7/10 17:29
 * @description:
 */
public class MethodRefTest {

    public static String stringOps(StrFunction strFunction, String s) {
        return strFunction.func(s);
    }

    public static void main(String[] args) {
        String inStr = "lambda add power to Java";
        String outStr = stringOps(MyStringOps::strReverse, inStr);
        System.out.println("原始字符串：" + inStr);
        System.out.println("反转后的字符串：" + outStr);
    }
}
