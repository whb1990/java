package main.java.com.study.leetCode;

/**
 * @author: whb
 * @date: 2020/3/10 18:20
 * @description: 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 */
public class leetCode367 {
    /**
     * 解法一：利用 1+3+5+7+9+…+(2n-1)=n^2，即完全平方数肯定是前n个连续奇数的和
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int sumNum = 1;
        while (num > 0) {
            num -= sumNum;
            sumNum += 2;
        }
        return num == 0;
    }

    /**
     * 解法二：二分查找
     */
    public boolean isPerfectSquare2(int num) {
        long left = 1, right = num;
        while (left < right) {
            long middle = (left + right) >>> 1;
            if (middle * middle < num) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        if (right * right == num) {
            return true;
        }
        return false;
    }
}
