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
    /**
     * 思路:
     * 对于给定大小的 stones,最后一步肯定是将 K 堆 stone 合并为 1 堆，因此首先需要将 N 堆 stone 合并为 K 堆。可以用以下关系简单表示：
     *
     * 1、N堆=> K堆 => 1堆
     * 设将所有 N 堆 stone 转换为 1 堆所需要的步骤为 a 步，则必须满足的条件为：
     * N-a*K+a=1
     * 将其转换一下：
     * N-a*K+a=1 <=> N-a(K-1)=1 <=> N-1=a(K-1) => (N-1)%(K-1)=0。
     * 因此要能够转换必须满足的条件为：(N-1)%(K-1)=0。
     *
     * 2、要求 N 堆转换为 1 堆所需的成本为：
     * 2.1、K堆转换为 1 堆所需的成本：
     * 因为 K 堆能直接合并成为一堆，因此这个很好求了，直接将对应的 stones 累加即可，对应公式为 sum(stones)。
     * 2.2、N 堆转换为 K 堆所需的成本：
     * 2.2.1、当N<K时，N 堆无法转换成为 K 堆。
     * 2.2.2、当N=K时，N 堆转换为K堆的成本为：0。
     * 2.2.3、当N>K时，转换为子问题来求解：
     * 将 N 堆由 m 位置分为两个部分：
     *
     * [start,m]部分 ①
     * 将此部份再分为 K-1 堆
     * [m+1,end]部分 ②
     * 将此部份分为 1 堆
     * 因此此时可以转换为子问题求解了：
     *
     * 当 k>1 时
     * f(start,end,k)=min(f(start,m,k-1)+f(m+1,end,1))
     * 当 k==1 时
     * f(start,end,1)=f(start,end,K) + sum(start,end)
     * @param stones
     * @param K
     * @return
     */
    public static int mergeStones(int[] stones, int K) {
        // 是否有解的前提条件
        if ((stones.length - 1) % (K - 1) != 0) {
            return -1;
        }
        //前缀和
        int[] preSum = new int[stones.length + 1];
        for (int i = 1; i <= stones.length; i++) {
            preSum[i] = preSum[i - 1] + stones[i - 1];
        }
        //k能取到K 因故是K+1
        int[][][] dp = new int[stones.length][stones.length][K + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = 0; j < stones.length; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
            //从下标 i 合并到下标 i 成本为0
            dp[i][i][1] = 0;
        }
        //区间dp模板
        // 枚举区间长度
        for (int len = 2; len <= stones.length; len++) {
            // 枚举区间起点
            for (int i = 0; i <= stones.length - len; i++) {
                int j = i + len - 1;
                // 枚举堆数
                for (int k = 2; k <= K; k++) {
                    // 枚举分界点，m 跳步应该是K-1,不应该用k-1，因为是每次合并K个得到K-1堆;
                    for (int m = i; m < j; m += K - 1) {
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][m][1] + dp[m + 1][j][k - 1]);
                    }
                    dp[i][j][1] = dp[i][j][k] + (preSum[j + 1] - preSum[i]);
                }
            }
        }
        return dp[0][stones.length - 1][1];
    }

    /**
     * 二维DP
     *上述解法的时间复杂度是O(n^3*k)，可以对它进行优化。
     * 定义dp[i][j]为尽可能多的合并区间[i, j] 所需的成本，不一定能合并成一堆，但合并完成后剩下的堆数一定小于k，更具体地，剩余的堆数一定是(n - 1) % (k - 1) + 1。
     * 证明：
     * 已知一次合并会导致堆数减少k-1，假设最多进行了a次合并，则有
     * remain = n - (k - 1) * a，1 <= remain <= k - 1，
     * ⇒ remain - 1 = n - 1 - (k - 1) * a
     * ⇒ remain - 1 = (n - 1) % (k - 1)
     * ⇒ remain = (n - 1) % (k - 1) + 1
     * 证毕。
     *
     * 参照解法一来定义状态转移方程，同样将区间[i，j]划分为两部分。
     * 我们保证将左部分合并成1堆，而尽可能多地合并右部分。（左部分需要满足(len - 1) % (k - 1) == 0）。
     * 右部分剩余堆数满足1 <= remain <= k - 1，如果最后右部分剩余k-1堆（也即(j - i) % (k - 1) == 0），则还可以继续将这两部分合并成1堆。
     * 因此合并区间[i，j]的成本是合并其左右部分成本之和（对于最优的划分）。如果可以进一步合并的话，则额外的成本是sum(i, j)。
     * 状态转移方程为：dp[i][j] = min(dp[i][p] + dp[p + 1][j]), i <= p < j，如果可以继续合并，dp[i][j] += sum(i, j)。
     *
     * 这样的话枚举的区间长度就必须从k开始了，因为长度在[1，k-1]之间的区间已经无法进行合并了，它们的dp[i][j] == 0。
     * @param stones
     * @param K
     * @return
     */
    public static int mergeStones2(int[] stones, int K) {
        if ((stones.length - 1) % (K - 1) != 0) {
            return -1;
        }
        int[] preSum = new int[stones.length + 1];
        for (int i = 1; i <= stones.length; i++) {
            preSum[i] = preSum[i - 1] + stones[i - 1];
        }
        int[][] dp = new int[stones.length][stones.length];
        for (int[] p : dp) {
            Arrays.fill(p, Integer.MAX_VALUE);
        }
        for (int i = 0; i < stones.length; i++) {
            dp[i][i] = 0;
        }
        for (int len = 2; len <= stones.length; len++) {
            for (int i = 0; i <= stones.length - len; i++) {
                int j = i + len - 1;
                for (int k = 2; k <= K; k++) {
                    for (int m = i; m < j; m += K - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                    }
                    if ((j - i) % (K - 1) == 0) {
                        dp[i][j] += preSum[j + 1] - preSum[i];
                    }
                }
            }
        }
        return dp[0][stones.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(mergeStones(new int[]{3, 2, 4, 1}, 2));
        System.out.println(mergeStones(new int[]{3, 2, 4, 1}, 3));
        System.out.println(mergeStones(new int[]{3, 5, 1, 2, 6}, 3));
        System.out.println("============空间优化Dp================");
        System.out.println(mergeStones2(new int[]{3, 2, 4, 1}, 2));
        System.out.println(mergeStones2(new int[]{3, 2, 4, 1}, 3));
        System.out.println(mergeStones2(new int[]{3, 5, 1, 2, 6}, 3));
    }
}
