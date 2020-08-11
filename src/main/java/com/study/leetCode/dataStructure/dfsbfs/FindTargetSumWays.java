package main.java.com.study.leetCode.dataStructure.dfsbfs;

/**
 * @author: whb
 * @date: 2020/5/29 14:35
 * @description: LeetCode-494-目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例 1:
 * <p>
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
    public static void main(String[] args) {
        FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(findTargetSumWays.findTargetSumWaysDFS(nums, S));
    }

    /**
     * DFS(递归)思路比较简单，将每种可能性都走了一遍，由主函数返回那个正确的
     *
     * @param nums
     * @param S
     * @return
     */
    int dfsResult = 0;

    public int findTargetSumWaysDFS(int[] nums, int S) {
        dfs(nums, S, 0);
        return dfsResult;
    }

    private void dfs(int[] nums, int S, int length) {
        if (length >= nums.length) {
            if (S == 0) {
                dfsResult++;
            }
            return;
        }
        dfs(nums, S - nums[length], length + 1);
        dfs(nums, S + nums[length], length + 1);
    }

    /**
     * 动态规划解法
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
    public int findTargetSumWaysDP(int[] nums, int S) {
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
}
