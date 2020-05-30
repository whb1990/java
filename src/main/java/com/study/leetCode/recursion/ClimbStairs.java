package main.java.com.study.leetCode.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: whb
 * @date: 2020/5/30 14:06
 * @description: LeetCode-70-爬楼梯
 */
public class ClimbStairs {
    /**
     * 动态规划解法
     * 第 ii 阶可以由以下两种方法得到：
     * <p>
     * 在第 (i-1) 阶后向上爬一阶。
     * <p>
     * 在第 (i-2)阶后向上爬 22 阶。
     * <p>
     * 所以到达第 ii 阶的方法总数就是到第 (i-1)阶和第 (i-2)阶的方法数之和。
     * <p>
     * 令 dp[i]表示能到达第 ii 阶的方法总数：
     * <p>
     * dp[i]=dp[i-1]+dp[i-2]
     *
     * @param n
     * @return
     */
    public int climbStairsDP(int n) {
        if (n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 递归记忆化法
     */
    Map<Integer, Integer> cacheMap = new HashMap<>();

    public int climbStairs(int n) {
        if (cacheMap.containsKey(n)) {
            return cacheMap.get(n);
        }
        int result = 0;
        if (n < 3) {
            result = n;
        } else {
            result = climbStairs(n - 1) + climbStairs(n - 2);
        }
        cacheMap.put(n, result);
        return result;
    }
}
