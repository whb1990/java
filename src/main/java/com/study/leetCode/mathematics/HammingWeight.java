package main.java.com.study.leetCode.mathematics;

/**
 * @author： whb
 * @description： LeetCode-191-位1的个数
 * @date： 2020-11-06 10:45
 * 难度：简单
 * 标签：数学、位运算
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 *
 * 示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 */
public class HammingWeight {
    /**
     * 位操作
     * 不断把数字最后一个 1 反转，并把答案加一。当数字变成 0 的时候偶，我们就知道它没有 1 的位了，此时返回答案。
     * 对于任意数字 n ，将 n 和 n - 1 做与运算，会把最后一个 1 的位变成 0 。
     * 在二进制表示中，数字 n 中最低位的 1 总是对应 n - 1 中的 0 。因此，将 n 和 n - 1 与运算总是能把 n 中最低位的 1 变成 0 ，并保持其他位不变。
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
        System.out.println(hammingWeight(00000000000000000000000010000000));
        System.out.println(hammingWeight(9));
    }
}

