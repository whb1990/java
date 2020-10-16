package main.java.com.study.leetCode.mathematics;

/**
 * @author： whb
 * @description： LeetCode-400-第N个数字
 * @date： 2020-10-16 15:55
 * 难度：中等
 * 标签：数学
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 *
 * 注意:
 * n 是正数且在32位整数范围内 ( n < 2^31)。
 *
 * 示例 1:
 * 输入:
 * 3
 * 输出:
 * 3
 *
 * 示例 2:
 * 输入:
 * 11
 * 输出:
 * 0
 *
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 */
public class FindNthDigit {
    /**
     * 解题思路：
     * 文名词规定如下：
     *
     * 1、将 101112⋯ 中的每一位称为 数位 ，记为 n ；
     * 2、将 10, 11, 12, ⋯ 称为 数字 ，记为 num ；
     * 3、数字 10 是一个两位数，称此数字的 位数 为 2 ，记为 digit ；
     * 4、每 digit 位数的起始数字（即：1, 10, 100, ⋯），记为 start ；
     *
     * 数字范围            位数              数字数量             数位数量
     *   1~9                1                    9                   9
     *  10~99               2                   90                  180
     *  100~999             3                  900                 2700
     *  ...                 ...                 ...                ...
     * start~end           digit              9*start            9*start*digit
     *
     * 观察上表，可推出各 digit 下的数位数量 count 的计算公式：
     * count=9×start×digit
     *
     *根据以上分析，可将求解分为三步：
     * 1、确定 n 所在 数字 的 位数 ，记为 digit ；
     * 2、确定 n 所在的 数字 ，记为 num ；
     * 3、确定 n 是 num 中的哪一数位，并返回结果；
     *
     * @param n
     * @return
     */
    public static int findNthDigit(int n) {
        //初始位数为1
        int digit = 1;
        //数字初始值为1，数量为9
        long start = 1, count = 9;
        //循环执行 n 减去 一位数、两位数、... 的数位数量 count ，直至 n ≤count 时跳出。
        //由于 n 已经减去了一位数、两位数、...、(digit-1) 位数的 数位数量 count ，因而此时的 n 是从起始数字 start开始计数的。
        while (n > count) {
            n -= count;
            digit++;
            start *= 10;
            count = 9 * start * digit;
        }
        //所求数位 在从数字 start 开始的第 [(n−1)/digit] 个 数字 中（ start 为第 0 个数字）
        long num = start + (n - 1) / digit;
        //所求数位为数字 num 的第 (n−1)%digit 位（数字的首个数位为第 0 位）
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(3));
        System.out.println(findNthDigit(11));
    }
}
