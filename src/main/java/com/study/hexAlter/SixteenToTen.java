package main.java.com.study.hexAlter;

import java.util.Scanner;

/**
 * @author: whb
 * @date: 2019/9/29 10:29
 * @description: 十六进制转十进制
 */
public class SixteenToTen {
    public static void main(String[] args) {
        System.out.println("请输入要转换的十六进制的数：");
        Scanner scanner = new Scanner(System.in);
        //输入十六进制数
        String string = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            //将输入的十六进制字符串转化为单个字符
            int m = string.charAt(i);
            //将字符对应的ASCII值转为数值
            int num = m >= 'A' ? m - 'A' + 10 : m - '0';
            sum += Math.pow(16, string.length() - 1 - i) * num;
        }
        System.out.println("转换的十进制的数为：" + sum);
    }
}
