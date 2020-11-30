package main.java.com.study.leetCode.dp;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-1671-得到山形数组的最少删除次数
 * @date： 2020-11-30 15:11
 * 难度：困难
 * 标签：动态规划
 * 我们定义 arr 是 山形数组 当且仅当它满足：
 * <p>
 * arr.length >= 3
 * 存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且：
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 给你整数数组 nums​ ，请你返回将 nums 变成 山形状数组 的​ 最少 删除次数。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,1]
 * 输出：0
 * 解释：数组本身就是山形数组，所以我们不需要删除任何元素。
 * <p>
 * 示例 2：
 * 输入：nums = [2,1,1,5,6,2,3,1]
 * 输出：3
 * 解释：一种方法是将下标为 0，1 和 5 的元素删除，剩余元素为 [1,5,6,3,1] ，是山形数组。
 * <p>
 * 示例 3：
 * 输入：nums = [4,3,2,1,1,2,3,1]
 * 输出：4
 * <p>
 * 示例4：
 * 输入：nums = [1,2,3,4,4,3,2,1]
 * 输出：1
 * <p>
 * 提示：
 * 3 <= nums.length <= 1000
 * 1 <= nums[i] <= 109
 * 题目保证 nums 删除一些元素后一定能得到山形数组。
 */
public class MinimumMountainRemovals {
    /**
     * 解题思路
     * 本题可以看做最长上升子序列的变形（左边上升子序列，右边下降子序列）
     * 用两个dp数组来记录，leftdp[i]表示以从左到右数第i个数为山峰，最大长度可以达到多长，
     * 而rightdp[i]表示从有右到左第i个数为山峰，最大长度可以达到多长，最后遍历一遍以每个点为山峰，左+右-1的最大就是结果。
     * 计算两组dp的时间为O(n^2)，而最后遍历一遍是O(n)，所以总的复杂度是O(n^2)。
     *
     * @param nums
     * @return
     */
    public static int minimumMountainRemovals(int[] nums) {
        int[] leftDp = lengthOfLIS(nums);
        reverse(nums);
        int[] rightDp = lengthOfLIS(nums);
        int res = nums.length;
        for (int i = 1; i < nums.length - 1; i++) {
            res = Math.min(res, nums.length - (leftDp[i] + rightDp[nums.length - 1 - i] - 1));
        }
        return res;
    }

    /**
     * 计算最长上升子序列
     *
     * @param nums
     * @return
     */
    private static int[] lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    private static void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        System.out.println(minimumMountainRemovals(new int[]{1, 3, 1}));
        System.out.println(minimumMountainRemovals(new int[]{2, 1, 1, 5, 6, 2, 3, 1}));
        System.out.println(minimumMountainRemovals(new int[]{4, 3, 2, 1, 1, 2, 3, 1}));
        System.out.println(minimumMountainRemovals(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
    }
}
