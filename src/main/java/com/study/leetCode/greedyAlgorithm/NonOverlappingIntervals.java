package main.java.com.study.leetCode.greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: whb
 * @date: 2019/10/15 11:28
 * @description: LeetCode-435-无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 * 示例 1:
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 * 示例 2:
 * 输入: [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 *
 * 示例 3:
 * 输入: [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class NonOverlappingIntervals {
    /**
     * 贪心策略，先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
     *
     * 在每次选择中，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
     *
     * 按区间的结尾进行升序排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
     *
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }

    /**
     * 动态规划，转化成最长上升子序列问题
     * 先看下最终剩下的区间。由于剩下的区间都是不重叠的，因此剩下的相邻区间的后一个区间的开始一定是不小于前一个区间的结束的。
     *
     * 比如剩下的区间是[ [1,2], [2,3], [3,4] ]。就是第一个区间的 2 小于等于 第二个区间的 2，第二个区间的 3 小于等于第三个区间的 3。
     *
     * 不难发现如果将前面区间的结束和后面区间的开始结合起来看，其就是一个非严格递增序列。而我们的目标就是删除若干区间，从而剩下最长的非严格递增子序列。
     *
     * 如果对区间按照起点或者终点进行排序，那么就转化为最长递增子序列问题了。由于是一个区间，因此需要拿后面的开始和前面的结束进行比较。
     *
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervalsDp(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int[] dp = new int[intervals.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < intervals.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    break;
                }
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return intervals.length - res;
    }

    public static void main(String[] args) {
        System.out.println("==========贪心策略============");
        System.out.println(eraseOverlapIntervals(new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        }));
        System.out.println(eraseOverlapIntervals(new int[][]{
                {1, 2},
                {1, 2},
                {1, 2}
        }));
        System.out.println(eraseOverlapIntervals(new int[][]{
                {1, 2},
                {2, 3}
        }));

        System.out.println("*************动态规划*****************");
        System.out.println(eraseOverlapIntervalsDp(new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        }));
        System.out.println(eraseOverlapIntervalsDp(new int[][]{
                {1, 2},
                {1, 2},
                {1, 2}
        }));
        System.out.println(eraseOverlapIntervalsDp(new int[][]{
                {1, 2},
                {2, 3}
        }));
    }
}
