package main.java.com.study.leetCode.dp;

import java.util.Arrays;

/**
 * @author: whb
 * @date: 2020/8/5 14:38
 * @description: LeetCode-213-打家劫舍Ⅱ
 * 难度：中等
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * <p>
 * 示例 2:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class RobⅡ {
    /**
     * 动态规划
     * 思路：
     * 在 [0:n-1] 中找到最大值，在 [1:n] 中找到最大值
     * 最后获取最大值
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robAmount(Arrays.copyOfRange(nums, 0, nums.length - 1)), robAmount(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private static int robAmount(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    /**
     * 动态规划+滚动数组
     *
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private static int rob(int[] nums, int start, int end) {
        int first = 0, second = 0, rob = 0;
        for (int i = start; i < end; i++) {
            rob = Math.max(first + nums[i], second);
            first = second;
            second = rob;
        }
        return rob;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob2(new int[]{2, 3, 2}));
        System.out.println(rob2(new int[]{1, 2, 3, 1}));
    }
}
