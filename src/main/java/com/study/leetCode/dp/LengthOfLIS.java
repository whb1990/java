package main.java.com.study.leetCode.dp;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-300-最长上升子序列
 * @date： 2020-11-16 16:15
 * 难度：中等
 * 标签：二分查找、动态规划
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class LengthOfLIS {
    /**
     * 动态规划解法
     * 状态定义：
     * dp[i] 的值代表 nums 前 i 个数字的最长子序列长度。
     * 转移方程： 设 j∈[0,i)，考虑每轮计算新 dp[i] 时，遍历 [0,i) 列表区间，做以下判断：
     *
     * 当 nums[i] > nums[j] 时： nums[i] 可以接在 nums[j]（此题要求严格递增），此情况下最长上升子序列长度为 dp[j] + 1；
     * 当 nums[i] <= nums[j] 时： nums[i]无法接在 nums[j]之后，此情况上升子序列不成立，跳过。
     * 上述所有 1. 情况 下计算出的 dp[j] + 1 的最大值，为直到 i 的最长上升子序列长度（即 dp[i]）。
     * 实现方式为遍历 j 时，每轮执行 dp[i] = max(dp[i], dp[j] + 1)。
     * 转移方程： dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)。
     * 初始状态：
     *
     * dp[i] 所有元素置 1，含义是每个元素都至少可以单独成为子序列，此时长度都为 1。
     * 返回值：
     *
     * 返回 dp 列表最大值，即可得到全局最长上升子序列长度。
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
