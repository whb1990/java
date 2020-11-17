package main.java.com.study.leetCode.interval;

import main.java.com.study.leetCode.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-986-区间列表的交集
 * @date： 2020-11-17 8:43
 * 难度：中等
 * 标签：双指针
 * 给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。
 *
 * 返回这两个区间列表的交集。
 *
 * （形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
 *
 * 示例：
 *
 * 输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 *
 *
 * 提示：
 *
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 */
public class IntervalIntersection {
    /**
     * 双指针解法
     * 思路：
     * 用两个指针，分别扫描 A、B 数组，根据子区间的左右端，求出一个交集区间
     * 指针移动，直至指针越界，得到由交集区间组成的数组。
     *
     * 怎么求交集区间：
     * 交集区间的 start 取的是 A、B 子区间中较大的左界。
     * 交集区间的 end 取的是 A、B 子区间中较小的右界。
     * 只要 start <= end，就形成了一个交集区间。
     *
     * 双指针移动的时机：
     * 求完一个交集区间后，较早结束的子区间，不可能再和别的子区间有重叠，它的指针要移动。
     * 较长的子区间还有可能和别人重叠，它的指针暂时不动。
     * @param A
     * @param B
     * @return
     */
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int a1 = A[i][0], a2 = A[i][1];
            int b1 = B[j][0], b2 = B[j][1];
            if (b2 >= a1 && a2 >= b1) {
                res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }
            if (a2 < b2) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        CommonUtils.printInt2Arr(intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}));
    }
}
