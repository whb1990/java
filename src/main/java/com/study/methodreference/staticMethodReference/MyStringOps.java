package main.java.com.study.methodreference.staticMethodReference;

/**
 * @author: whb
 * @date: 2019/7/10 17:26
 * @description: 字符串反转
 */
public class MyStringOps {

    /**
     * 静态方法反转字符串
     */
    public static String strReverse(String str) {
        StringBuilder result = new StringBuilder("");
        for (int i = str.length() - 1; i >= 0; i--) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }
}
