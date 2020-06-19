package main.java.com.study.leetCode.dataStructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: whb
 * @date: 2020/5/30 18:48
 * @description: LeetCode-56-合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        //边界判断
        if (intervals.length <= 1) {
            return intervals;
        }
        //按每个区间的起点排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        //利用list存储合并好的区间
        List<int[]> result = new ArrayList<>();
        //初始将第一个区间放入合并好的结果集中
        result.add(intervals[0]);
        //记录上一合并好的区间在list中位置
        int last = 0;
        //遍历合并后面的区间
        for (int i = 1; i < intervals.length; i++) {
            //上一合并好的区间的起点和终点
            int lastStart = result.get(last)[0];
            int lastEnd = result.get(last)[1];
            //当前要合并区间的起点和终点
            int start = intervals[i][0];
            int end = intervals[i][1];
            //左边界重合
            if (lastStart == start) {
                if (end > lastEnd) {
                    result.set(last, new int[]{lastStart, end});
                }
            } else {
                //如果左边界不重合
                if (start > lastEnd) {
                    //如果要合并的区间的起点大于上一合并好的区间的终点
                    result.add(new int[]{start, end});
                    last++;
                } else {
                    //要合并的区间与上一合并好的区间有交叉
                    if (end > lastEnd) {
                        result.set(last, new int[]{lastStart, end});
                    }
                }
            }
        }
        return result.toArray(new int[0][]);
    }
}
