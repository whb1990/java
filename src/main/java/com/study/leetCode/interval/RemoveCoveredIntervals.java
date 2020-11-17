package main.java.com.study.leetCode.interval;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-1228-删除被覆盖的区间
 * @date： 2020-11-17 8:19
 * 难度：中等
 * 标签：贪心算法、排序、Line Sweep
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 * <p>
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 * <p>
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 * <p>
 * 示例：
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 * <p>
 * 提示：​​​​​​
 * 1 <= intervals.length <= 1000
 * 0 <= intervals[i][0] < intervals[i][1] <= 10^5
 * 对于所有的 i != j：intervals[i] != intervals[j]
 */
public class RemoveCoveredIntervals {
    public static int removeConveredIntervals(int[][] intervals) {
        //排序：起点升序，终点降序
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int left = intervals[0][0], right = intervals[0][1];
        //记录重叠区间数
        int covered = 0;
        for (int i = 1; i < intervals.length; i++) {
            //重叠区间
            if (left <= intervals[i][0] && right >= intervals[i][1]) {
                covered++;
            } else if (right >= intervals[i][0] && right <= intervals[i][1]) {
                //相交区间
                right = intervals[i][1];
            } else if (right < intervals[i][0]) {
                //不相交区间
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        return intervals.length - covered;
    }

    public static void main(String[] args) {
        System.out.println(removeConveredIntervals(new int[][]{{1, 4}, {3, 6}, {2, 8}}));
    }
}
