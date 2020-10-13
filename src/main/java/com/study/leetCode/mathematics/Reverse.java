package main.java.com.study.leetCode.mathematics;

/**
 * @author： whb
 * @description： LeetCode-7-整数反转
 * @date： 2020-10-13 17:04
 * 难度：简单
 * 标签：数学
 */
public class Reverse {
    public static int reverse(int x) {
        //如果x的值为0，直接返回
        if (x == 0) {
            return 0;
        }
        //判断x是正值还是负值
        boolean negavite = x < 0 ? true : false;
        x = Math.abs(x);
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            //如果溢出了直接返回0
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }
            result = result * 10 + digit;
            x /= 10;
        }
        return negavite ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }
}
