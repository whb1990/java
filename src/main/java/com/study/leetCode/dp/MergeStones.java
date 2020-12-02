package main.java.com.study.leetCode.dp;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-1000-合并石头的最低成本
 * @date： 2020-12-02 15:17
 * 难度：困难
 * 标签：区间动态规划
 * 有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。
 *
 * 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。
 *
 * 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。
 *
 *
 * 示例 1：
 *
 * 输入：stones = [3,2,4,1], K = 2
 * 输出：20
 * 解释：
 * 从 [3, 2, 4, 1] 开始。
 * 合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。
 * 合并 [4, 1]，成本为 5，剩下 [5, 5]。
 * 合并 [5, 5]，成本为 10，剩下 [10]。
 * 总成本 20，这是可能的最小值。
 *
 * 示例 2：
 *
 * 输入：stones = [3,2,4,1], K = 3
 * 输出：-1
 * 解释：任何合并操作后，都会剩下 2 堆，我们无法再进行合并。所以这项任务是不可能完成的。.
 *
 * 示例 3：
 *
 * 输入：stones = [3,5,1,2,6], K = 3
 * 输出：25
 * 解释：
 * 从 [3, 5, 1, 2, 6] 开始。
 * 合并 [5, 1, 2]，成本为 8，剩下 [3, 8, 6]。
 * 合并 [3, 8, 6]，成本为 17，剩下 [17]。
 * 总成本 25，这是可能的最小值。
 *
 *
 * 提示：
 * 1 <= stones.length <= 30
 * 2 <= K <= 30
 * 1 <= stones[i] <= 100
 */
public class MergeStones {
    public static int mergeStones(int[] stones, int K) {
        if ((stones.length - 1) % (K - 1) != 0) {
            return -1;
        }
        int[] preSum = new int[stones.length + 1];
        for (int i = 1; i <= stones.length; i++) {
            preSum[i] = preSum[i - 1] + stones[i - 1];
        }
        int[][][] dp = new int[stones.length][stones.length][K + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = 0; j < stones.length; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
            dp[i][i][1] = 0;
        }
        for (int len = 2; len <= stones.length; len++) {
            for (int i = 0; i <= stones.length - len; i++) {
                int j = i + len - 1;
                for (int k = 2; k <= K; k++) {
                    for (int m = i; m < j; m += K - 1) {
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][m][1] + dp[m + 1][j][k - 1]);
                    }
                    dp[i][j][1] = dp[i][j][k] + (preSum[j + 1] - preSum[i]);
                }
            }
        }
        return dp[0][stones.length - 1][1];
    }

    public static void main(String[] args) {
        System.out.println(mergeStones(new int[]{3, 2, 4, 1}, 2));
        System.out.println(mergeStones(new int[]{3, 2, 4, 1}, 3));
        System.out.println(mergeStones(new int[]{3, 5, 1, 2, 6}, 3));
    }
}
