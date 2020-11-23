package main.java.com.study.leetCode.greedyAlgorithm;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-452-用最少数量的箭引爆气球
 * @date： 2020-11-23 8:37
 * 难度：中等
 * 标签：贪心算法、排序
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 *
 * 示例 1：
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 *
 * 示例 2：
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 *
 * 示例 3：
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 *
 * 示例 4：
 * 输入：points = [[1,2]]
 * 输出：1
 *
 * 示例 5：
 * 输入：points = [[2,3],[2,3]]
 * 输出：1
 *
 *
 * 提示：
 * 0 <= points.length <= 104
 * points[i].length == 2
 */
public class FindMinArrowShots {
    /**
     * 每个气球都是有宽度的，分别是左边界和右边界，这里只需要把所有的气球按照右边界的大小进行排序。
     * 然后把第一支箭尽可能的往第一个气球的右边靠，这样第一支箭引爆气球的数量就是最多的。
     * 同理，第二支箭要尽可能的往第二个气球（这里不是排序后的第二个气球，这里的第二个气球是和第一个气球坐标没有交集的那个气球）的右边靠……。
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length <= 1) {
            return points.length;
        }
        //按照每个气球的右边界排序
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        // res：统计箭的数量，start：获取排序后第一个气球右边界的位置，可以认为是箭射入的位置
        int res = 0, start = points[0][1];
        for (int i = 0; i < points.length; i++) {
            //如果箭射入的位置小于下标为i这个气球的左边位置，说明这支箭不能
            //击爆下标为i的这个气球，需要再拿出一支箭，并且要更新这支箭射入的位置
            if (points[i][0] <= start && start <= points[i][1]) {
                continue;
            }
            res++;
            start = points[i][1];
        }
        return res + 1;
    }

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}}));
        System.out.println(findMinArrowShots(new int[][]{{2, 3}, {2, 3}}));
        System.out.println(findMinArrowShots(new int[0][0]));
    }
}
