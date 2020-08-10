package main.java.com.study.leetCode.mathematics;

/**
 * @author: whb
 * @date: 2020/8/10 10:15
 * @description: LeetCode-693-交替位二进制数
 * 难度：简单
 * 标签：位运算
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 *
 * 示例 1:
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 *
 * 示例 2:
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 *
 * 示例 3:
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 *
 * 示例 4:
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 */
public class HasAlternatingBits {
    /**
     * 需要拿当前位二进制的数字与前一位二进制的数字进行比较，所以在进入循环之前，先通过int pre = n & 1获取第一位二进制的数字。
     * 在循环过程中如果发现当前位的数字与前一位相等(n & 1) == pre，就返回false。
     * 在循环中不断无符号右移n的同时，还要不断更新pre = n & 1。
     * 时间复杂度：O(1)O(1) 。运行时间依赖于数字n的位数。由于这题中n是 32 位数。空间复杂度是O(1)O(1)的。
     *
     * @param n
     * @return
     */
    public static boolean hasAlternatingBits(int n) {
        int pre = -1;
        while (n > 0) {
            if (pre != -1 && pre == (n & 1)) {
                return false;
            }
            pre = n & 1;
            n = n >> 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(11));
        System.out.println(hasAlternatingBits(10));
    }
}
