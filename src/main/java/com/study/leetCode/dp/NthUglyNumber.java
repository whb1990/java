package main.java.com.study.leetCode.dp;

/**
 * @author： whb
 * @description： LeetCode-264-丑数Ⅱ
 * @date： 2020-10-22 16:51
 * 难度：中等
 * 标签：堆、数学、动态规划
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 *
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * 1 是丑数。
 * n 不超过1690。
 */
public class NthUglyNumber {
    /**
     * 动态规划+三指针
     * 从数组中只包含一个丑数数字 1 开始，使用三个指针i2,i3和i5，标记所指向丑数要乘以的因子。
     * 算法很简单：在 2×nums[i2]，3×nums[i3] 和 5×nums[i5] 选出最小的丑数并添加到数组中。并将该丑数对应的因子指针往前走一步。
     * 三个指针p2，p3，p5，但是没有说明其含义，实际上pi的含义是有资格同i相乘的最小丑数的位置。这里资格指的是：如果一个丑数nums[pi]通过乘以i可以得到下一个丑数，那么这个丑数nums[pi]就永远失去了同i相乘的资格（没有必要再乘了），我们把pi++让nums[pi]指向下一个丑数即可。
     * <p>
     * 不懂的话举例说明：
     * <p>
     * 一开始，丑数只有{1}，1可以同2，3，5相乘，取最小的1×2=2添加到丑数序列中。
     * <p>
     * 现在丑数中有{1，2}，在上一步中，1已经同2相乘过了，所以今后没必要再比较1×2了，我们说1失去了同2相乘的资格。
     * <p>
     * 现在1有与3，5相乘的资格，2有与2，3，5相乘的资格，但是2×3和2×5是没必要比较的，因为有比它更小的1可以同3，5相乘，所以我们只需要比较1×3，1×5，2×2。
     * <p>
     * 依此类推，每次我们都分别比较有资格同2，3，5相乘的最小丑数，选择最小的那个作为下一个丑数，假设选择到的这个丑数是同i（i=2，3，5）相乘得到的，所以它失去了同i相乘的资格，把对应的pi++，让pi指向下一个丑数即可。
     *
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        //dp[i] 表示第 i 个丑数
        //dp[i] = 2^x * 3^y * 5^z, x,y,z >= 0
        //第 i 个丑数一定是在 d[i] 之前的某个丑数 d[j] 之上乘以 2 || 3 || 5 的结果, 而且要是大于 dp[i-1] 中最小的那一个
        int[] dp = new int[n];
        dp[0] = 1;
        int tmp = 1, i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            tmp = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
            dp[i] = tmp;
            if (tmp == dp[i2] * 2) {
                i2++;
            }
            if (tmp == dp[i3] * 3) {
                i3++;
            }
            if (tmp == dp[i5] * 5) {
                i5++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
