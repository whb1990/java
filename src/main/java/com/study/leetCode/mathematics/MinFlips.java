package main.java.com.study.leetCode.mathematics;

/**
 * @author： whb
 * @description： LeetCode-1318-或运算的最小翻转次数
 * @date： 2020-12-03 16:30
 * 难度：中等
 * 标签：位运算
 * 给你三个正整数 a、b 和 c。
 *
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
 *
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 *
 * 示例 1：
 *
 * 输入：a = 2, b = 6, c = 5
 * 输出：3
 * 解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c
 *
 * 示例 2：
 *
 * 输入：a = 4, b = 2, c = 7
 * 输出：1
 *
 * 示例 3：
 *
 * 输入：a = 1, b = 2, c = 3
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= a <= 10^9
 * 1 <= b <= 10^9
 * 1 <= c <= 10^9
 */
public class MinFlips {
    /**
     * 1.利用 m = (a or b) xor c 得出哪几位不正确
     * 2.利用 m&(-m) 逐个获取不正确的位，然后获取要修改的次数
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int minFlips(int a, int b, int c) {
        int m = (a | b) ^ c, res = 0;
        while (m > 0) {
            int mask = m & (-m);
            if ((mask & c) > 0) {
                res++;
            } else {
                if ((mask & a) > 0) {
                    res++;
                }
                if ((mask & b) > 0) {
                    res++;
                }
            }
            m -= mask;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minFlips(2, 6, 5));
        System.out.println(minFlips(4, 2, 7));
        System.out.println(minFlips(1, 2, 3));
    }
}
