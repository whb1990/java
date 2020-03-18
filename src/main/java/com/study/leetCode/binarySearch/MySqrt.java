package main.java.com.study.leetCode.binarySearch;

/**
 * @author: whb
 * @date: 2020/3/10 18:40
 * @description: LeetCode-69-x的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {

    /**
     * 二分查找，用x/m<m而不是m*m>x防止溢出
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int min = 0;
        int max = x;
        while (max - min > 1) {
            int m = (max + min) / 2;
            if (x / m < m) {
                max = m;
            } else {
                min = m;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
