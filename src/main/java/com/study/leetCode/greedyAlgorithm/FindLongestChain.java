package main.java.com.study.leetCode.greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author： whb
 * @description： LeetCode-646-最长数对链
 * @date： 2020-11-30 17:56
 * 难度：中等
 * 标签：动态规划
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 *
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 * 示例：
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 *
 * 提示：
 *
 * 给出数对的个数在 [1, 1000] 范围内。
 */
public class FindLongestChain {
    /**
     * 贪心策略，同435.无重叠区间题
     *
     * @param pairs
     * @return
     */
    public static int findLongestChainGreedy(int[][] pairs) {
        if (pairs == null || pairs.length < 2) {
            return pairs.length;
        }
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int count = 1, end = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] <= end) {
                continue;
            }
            end = pairs[i][1];
            count++;
        }
        return count;
    }

    /**
     * 动态规划，思路跟435.无重叠区间一样
     *
     * @param pairs
     * @return
     */
    public static int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length < 2) {
            return pairs.length;
        }
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println("***********贪心策略*************");
        System.out.println(findLongestChainGreedy(new int[][]{
                {1, 2},
                {2, 3},
                {3, 4}
        }));
        System.out.println("=======动态规划=========");
        System.out.println(findLongestChain(new int[][]{
                {1, 2},
                {2, 3},
                {3, 4}
        }));
    }
}
