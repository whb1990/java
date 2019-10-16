package main.java.com.study.leetCode.greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: whb
 * @date: 2019/10/15 11:28
 * @description: 不重叠的区间个数
 * 题目描述：计算让一组区间不重叠所需要移除的区间个数。
 * <p>
 * 先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
 * <p>
 * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
 * <p>
 * 按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
 * 示例：
 * Input: [ [1,2], [1,2], [1,2] ]
 * Output: 2
 * 解析: 你需要删除两组 [1,2] 以使其余间隔不重叠。
 * Input: [ [1,2], [2,3] ]
 * Output: 0
 * 解析: 你不需要删除任何区间，因为它们已经不重叠了。
 */
public class NonOverlappingIntervals {
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

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        System.out.println(eraseOverlapIntervals(intervals));
        int[][] intervals2 = new int[][]{{1, 2}, {2, 3}};
        System.out.println(eraseOverlapIntervals(intervals2));
    }
}
