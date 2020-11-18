package main.java.com.study.leetCode.dataStructure.dfsbfs;

/**
 * @author: whb
 * @date: 2020/5/29 14:35
 * @description: LeetCode-494-目标和
 * 难度：中等
 * 标签：动态规划、回溯算法
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例 1:
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 */
public class FindTargetSumWays {
    /**
     * 回溯算法
     */
    int res = 0;

    public int findTargetSumWays(int[] nums, int S) {
        backtrack(nums, S, 0);
        return res;
    }

    private void backtrack(int[] nums, int rest, int index) {
        if (index == nums.length) {
            if (rest == 0) {
                res++;
            }
            return;
        }
        // choose过程：给nums[index]选择 - 号
        rest += nums[index];
        //进入下一次决策
        backtrack(nums, rest, index + 1);
        //unchoose回溯
        rest -= nums[index];
        //choose过程：给nums[index]选择 + 号
        rest -= nums[index];
        //进入下一次决策
        backtrack(nums, rest, index + 1);
        //unchoose回溯
        rest += nums[index];
    }

    /**
     * 动态规划
     * 这道题也是一个常见的背包问题，可以用类似求解背包问题的方法来求出可能的方法数。
     * <p>
     * 用 dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数。
     * 考虑第 i 个数 nums[i]，它可以被添加 + 或 -，因此状态转移方程如下：
     * <p>
     * dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWaysDP(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        sum = (sum + S) / 2;
        int[][] dp = new int[nums.length + 1][sum + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }

    /**
     * 动态规划解法，优化上面那个动态规划，从二维数组压缩为一维
     * sum(P)前面符号为+的集合；sum(N)前面符号为-的集合，所以题目就转化为
     * sum(P) - sum(N) = target
     * sum(nums) = sum(P) + sum(N)
     * ==> 2 * sum(P) = target + sum(nums);
     * ==> sum(P) = (target + sum(nums)) / 2
     * 因此题目转化为01背包问题，也就是能组合成容量为sum(P)的方式有多少种
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWaysDP2(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int w = (sum + S) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = w; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[w];
    }

    public static void main(String[] args) {
        FindTargetSumWays obj = new FindTargetSumWays();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(obj.findTargetSumWays(nums, S));
        System.out.println(obj.findTargetSumWaysDP(nums, S));
        System.out.println(obj.findTargetSumWaysDP2(nums, S));
    }
}
