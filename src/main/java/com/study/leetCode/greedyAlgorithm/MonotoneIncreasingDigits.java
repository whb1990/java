package main.java.com.study.leetCode.greedyAlgorithm;

/**
 * @author： whb
 * @description： LeetCode-738-单调递增的数字
 * @date： 2020-12-04 8:31
 * 难度：中等
 * 标签：贪心算法
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 *
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 *
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 */
public class MonotoneIncreasingDigits {
    /**
     * 思路：
     * 从右向左扫描数字，若发现当前数字比其左边一位（较高位）小，
     * 则把其左边一位数字减1，并将该位及其右边的所有位改成9
     */
    public static int monotoneIncreasingDigits(int N) {
        char[] ch = String.valueOf(N).toCharArray();
        int flag = ch.length;
        for (int i = ch.length - 1; i >= 1; i--) {
            if (ch[i] < ch[i - 1]) {
                flag = i;
                ch[i - 1]--;
            }
        }
        for (int i = flag; i < ch.length; i++) {
            ch[i] = '9';
        }
        return Integer.parseInt(new String(ch));
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(10));
        System.out.println(monotoneIncreasingDigits(1234));
        System.out.println(monotoneIncreasingDigits(332));
    }
}
