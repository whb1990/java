package main.java.com.study.leetCode.binarySearch;

/**
 * @author： whb
 * @description： LeetCode-LCP-12-小张刷题计划
 * @date： 2020-11-25 17:41
 * 难度：中等
 * 标签：二分查找
 * 为了提高自己的代码能力，小张制定了 LeetCode 刷题计划，他选中了 LeetCode 题库中的 n 道题，编号从 0 到 n-1，并计划在 m 天内按照题目编号顺序刷完所有的题目（注意，小张不能用多天完成同一题）。
 *
 * 在小张刷题计划中，小张需要用 time[i] 的时间完成编号 i 的题目。此外，小张还可以使用场外求助功能，通过询问他的好朋友小杨题目的解法，可以省去该题的做题时间。为了防止“小张刷题计划”变成“小杨刷题计划”，小张每天最多使用一次求助。
 *
 * 我们定义 m 天中做题时间最多的一天耗时为 T（小杨完成的题目不计入做题总时间）。请你帮小张求出最小的 T是多少。
 *
 * 示例 1：
 *
 * 输入：time = [1,2,3,3], m = 2
 *
 * 输出：3
 *
 * 解释：第一天小张完成前三题，其中第三题找小杨帮忙；第二天完成第四题，并且找小杨帮忙。这样做题时间最多的一天花费了 3 的时间，并且这个值是最小的。
 *
 * 示例 2：
 *
 * 输入：time = [999,999,999], m = 4
 *
 * 输出：0
 *
 * 解释：在前三天中，小张每天求助小杨一次，这样他可以在三天内完成所有的题目并不花任何时间。
 *
 *
 * 限制：
 *
 * 1 <= time.length <= 10^5
 * 1 <= time[i] <= 10000
 * 1 <= m <= 1000
 */
public class MinTime {
    /**
     * 跟LeetCode-410-分割数组的最大值 一个套路
     *
     * @param time
     * @param m
     * @return
     */
    public static int minTime(int[] time, int m) {
        //在[low, high]的区间二分搜索，每个区间段的最大和
        //low初始化为0（因为每个区间都可以减去这个区间的最大值，若区间只有一个元素，则减去自己就为0），
        // high初始化为数组之和，因为最大的区间为初始的大区间，所以（区间段的最大和）为所有元素之和
        int low = 0, high = 0;
        for (int t : time) {
            high += t;
        }
        //二分查找
        while (low < high) {
            //middle为正在搜索的区间的和的期望值
            int middle = low + ((high - low) >> 1);
            //need为这种分割条件下子区间的个数，totalTime为这个区间的综合，maxTime为这个区间的最大值
            int need = 1, totalTime = 0, maxTime = 0;
            //遍历数组
            for (int t : time) {
                totalTime += t;
                maxTime = Math.max(maxTime, t);
                //确定在每个区间和不超过middle的情况下，需要分割的子区间个数
                //超过了当前正在划分的区间的最大和的期望值，需要再开一个新区间
                if (totalTime - maxTime > middle) {
                    need++;
                    //新开区间总和为初始元素值
                    totalTime = t;
                    //新开区间最大值为初始元素值
                    maxTime = t;
                }
            }
            if (need > m) {
                //如果需要分割的子区间个数大于给定值，则说明区间和的期望值小了
                low = middle + 1;
            } else {
                //否则说明可能相等或大了
                high = middle;
            }
        }
        return low;
    }
}
