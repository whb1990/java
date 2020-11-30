package main.java.com.study.leetCode.dp;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-673-最长递增子序列的个数
 * @date： 2020-11-30 18:54
 * 难度：中等
 * 标签；
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 *
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 *
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 */
public class FindNumberOfLIS {
    /**
     * 假设对于以 nums[i] 结尾的序列，我们知道最长序列的长度 dp[i]，以及具有该长度的序列的 combination[i]。
     * 对于每一个 i<j 和一个 A[i]<A[j]，可以将一个 A[j] 附加到以 A[i] 结尾的最长子序列上。
     * 如果这些序列比 dp[j] 长，那么就有combination[i] 个长度为 length 的序列。
     * 如果这些序列的长度与 dp[j] 相等，那么现在就有 combination[i] 个额外的序列（即 combination[j]+=combination[i]）。
     *
     * @param nums
     * @return
     */
    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //dp数组用于计算最长递增子序列的长度
        int[] dp = new int[nums.length];
        //combination数组用于计算最长递增子序列的个数
        int[] combination = new int[nums.length];
        //初始最长递增子序列的长度和个数都为1
        Arrays.fill(dp, 1);
        Arrays.fill(combination, 1);
        //max用于记录最长递增子序列的长度， res用于记录个数
        int max = 1, res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //如果+1长于当前LIS 则组合数不变
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        combination[i] = combination[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        //如果+1等于当前LIS 则说明找到了新组合
                        combination[i] += combination[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == max) {
                res += combination[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
    }
}
