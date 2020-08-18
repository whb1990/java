package main.java.com.study.leetCode.dp;

/**
 * @author: whb
 * @date: 2020/8/18 11:25
 * @description: LeetCode-剑指Offer42-连续子数组的最大和
 * 难度：简单
 * 标签：分治算法、动态规划
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    /**
     * 1、创建dp数组
     * 2、初始化值: dp[0] = nums[0]
     * 3、每次遍历判断dp[i-1]是否大于0
     * 如果大于0, 则用dp[i-1] + nums[i]
     * 如果小于0,则直接使用nums[i]
     * 4、每次都记录max值
     * 5、最后返回max
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
