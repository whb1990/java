package main.java.com.study.leetCode.mathematics;

/**
 * @author： whb
 * @description： LeetCode-1680-连接连续二进制数字
 * @date： 2020-12-07 10:34
 * 难度：中等
 * 标签：数学、位运算
 * 给你一个整数 n ，请你将 1 到 n 的二进制表示连接起来，并返回连接结果对应的 十进制 数字对 109 + 7 取余的结果。
 *
 *
 * 示例 1：
 * 输入：n = 1
 * 输出：1
 * 解释：二进制的 "1" 对应着十进制的 1 。
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：27
 * 解释：二进制下，1，2 和 3 分别对应 "1" ，"10" 和 "11" 。
 * 将它们依次连接，我们得到 "11011" ，对应着十进制的 27 。
 *
 * 示例 3：
 * 输入：n = 12
 * 输出：505379714
 * 解释：连接结果为 "1101110010111011110001001101010111100" 。
 * 对应的十进制数字为 118505380540 。
 * 对 109 + 7 取余后，结果为 505379714 。
 *
 *
 * 提示：
 * 1 <= n <= 105
 */
public class ConcatenatedBinary {
    public static int concatenatedBinary(int n) {
        // 防止溢出
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            int len = Integer.toBinaryString(i).length();
            sum <<= len;
            sum += i;
            sum %= 1000000007;
        }
        return (int) sum;
    }

    /**
     * 原理：
     * 1、使用位运算思想
     * 2、假设n=3
     *    n=1 二进制为1
     *    n=2 二进制为10
     *    n=3 二进制为11
     * 假设res为最终结果值，一般会想到先将1-n的二进制字符串都求出来然后拼接，再转为十进制，比较暴力。
     *
     * 但其实有更简单的算法，因为，拼接的结果无非是res二进制向左移 x位得到的值与所拼接二进制字符串值的和。
     * 因此，事实上，x的值便是求解的关键。
     *
     * 容易看出，x即为值i表示的二进制字符串的位数，如何求得二进制字符串的位数呢？
     * 类比于十进制，10的整数次幂所表示的值的10进制位数刚好差距为1，如10^0，10^1，10^2，10^3
     * 类似的，2^0，2^1，2^2，2^3所表示的二进制的位数也刚好差距为1
     * 我们可以利用这一点来求解。
     * 如以n=3为例：
     * n=1时，二进制为1，res向左移动1位，与1相加，res值为1；
     * n=2时，二进制为10，res向左移动2位，与2相加，res值为6；
     * n=3时，二进制为11，res向左移动2位，与3相加，res值为27.
     *
     * 因此，我们只需要判断当前n值是否为为2的幂，如果是，位数偏移在之前的基础上加1，否则位数偏移不变
     * 判断n值是否为2的幂方法有很多，在这里我采用了一种比较简单的方法i & (i-1)是否等于0，如果i是2的幂，说明仅某一位为1，其余均为0，那么i-1即为其余位均为1，自然与运算为0。
     * 如果难以理解可以想象99和100的关系。
     * @param n
     * @return
     */
    public static int concatenatedBinary2(int n) {
        final int MOD = 1000000000 + 7;
        //long避免溢出
        long ans = 0;
        //需要移动的位数
        int bit = 0;
        for (int i = 1; i <= n; ++i) {
            //当i是2的n次方时，i & (i - 1) == 0 如： i = 4, 二进制i为100, i - 1 = 011， i & (i - 1) == 0
            if ((i & (i - 1)) == 0) {
                ++bit;
            }
            ans = ((ans << bit) + i) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(concatenatedBinary(1));
        System.out.println(concatenatedBinary(3));
        System.out.println(concatenatedBinary(12));

        System.out.println(concatenatedBinary2(1));
        System.out.println(concatenatedBinary2(3));
        System.out.println(concatenatedBinary2(12));
    }
}
