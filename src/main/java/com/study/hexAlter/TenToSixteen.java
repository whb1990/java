package main.java.com.study.hexAlter;

import java.util.Scanner;

/**
 * @author: whb
 * @date: 2019/9/29 10:21
 * @description: 十进制转十六进制
 */
public class TenToSixteen {

    /**
     * 这次算法用了StringBuffer效率更好
     */
    public static void main(String[] args) {
        System.out.println("请输入要转换的十进制的数：");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("转换的十六进制的数为：" + intToHex(n));
    }

    private static String intToHex(int n) {
        //StringBuffer s = new StringBuffer();
        StringBuilder sb = new StringBuilder(8);
        String a;
        char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (n != 0) {
            sb = sb.append(b[n % 16]);
            n = n / 16;
        }
        a = sb.reverse().toString();
        return a;
    }

}
