package main.java.com.study.utils;

/**
 * @author: whb
 * @date: 2019/6/24 14:53
 * @description: 工具类
 */
public class CommonUtils {

    /**
     * 遍历打印
     *
     * @param numArr
     */
    public static void display(int[] numArr) {
        if (numArr != null && numArr.length > 0) {
            for (int num : numArr) {
                System.out.print(num + "  ");
            }
        }
        System.out.println("");
    }
}
