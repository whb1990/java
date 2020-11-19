package main.java.com.study.leetCode.diffArr;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-1109-航班预订统计
 * @date： 2020-11-19 15:23
 * 难度：中等
 * 标签：数组、数学
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 我们这儿有一份航班预订表，表中第 i 条预订记录 bookings[i] = [j, k, l] 意味着我们在从 j 到 k 的每个航班上预订了 l 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。
 *
 *
 * 示例：
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 *
 *
 * 提示：
 * 1 <= bookings.length <= 20000
 * 1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
 * 1 <= bookings[i][2] <= 10000
 */
public class CorpFlightBookings {
    /**
     * 利用差分数组思想，具体看笔记。下面给出的是精简后的代码，重点理解自定义的差分数组对象。
     * 解题思路：
     * 换一种思路理解题意，将问题转换为：某公交车共有 n 站，第 i 条记录 bookings[i] = [i, j, k] 表示在 i 站上车 k 人，乘坐到 j 站，在 j+1 站下车，需要按照车站顺序返回每一站车上的人数
     * 根据 1 的思路，定义 counter[] 数组记录每站的人数变化，counter[i] 表示第 i+1 站。遍历 bookings[]：bookings[i] = [i, j, k] 表示在 i 站增加 k 人即 counters[i-1] += k，在 j+1 站减少 k 人即 counters[j] -= k
     * 遍历（整理）counter[] 数组，得到每站总人数： 每站的人数为前一站人数加上当前人数变化 counters[i] += counters[i - 1]
     * @param bookings
     * @param n
     * @return
     */
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        //存储结果
        int[] res = new int[n];
        //差分数组
        int[] diff = new int[n];
        for (int[] tmp : bookings) {
            diff[tmp[0] - 1] += tmp[2];
            if (tmp[1] < n) {
                diff[tmp[1]] -= tmp[2];
            }
        }
        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)));
    }
}
