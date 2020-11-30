package main.java.com.study.leetCode.stackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author： whb
 * @description： LeetCode-84-柱状图中最大的矩形
 * @date： 2020-11-30 11:27
 * 难度：困难
 * 标签：栈、数组
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class LargestRectangleArea {
    /**
     * 单调栈+哨兵
     *
     * 1.每个柱子都需要计算出一个矩形面积，这个面积至少等于柱子高度本身，即柱子高度 x 宽度1；
     *
     * 2.什么时候能够确定某个柱子所能得到的矩形面积呢?这个问题是理解的一个关键。
     * 那需要知道两个数字：
     * 左边界（往左数第一个比这个柱子小的下标位置）
     * 右边界（往右数第一个比这个柱子小的下标位置）
     * 知道这两个数字后，某柱的矩形面积 = 高度 x (右边界 - 左边界- 1)
     *
     * 3.单调栈的经典应用就是为每个元素找第一个比当前元素小的元素，这正是右边界的定义，即我们想知道每个柱子右边第一个比自己小的元素的位置。而左边界呢，那恰好就是栈内存着的上一个位置。因此个人认为这题想到用单调栈的一个思路就是想确认每个元素的右边界。
     *
     * 4.最左边的柱子的左边界和最右边柱子的右边界不存在，因此加上两个0在两边。为什么是0呢，因为它俩是用来做边界的，只有比1小才能确保它们一定是左右柱子的左右边界，这是边界的定义。
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        Deque<Integer> deque = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < newHeights.length; i++) {
            while (!deque.isEmpty() && newHeights[i] < newHeights[deque.peek()]) {
                maxArea = Math.max(maxArea, newHeights[deque.poll()] * (i - deque.peek() - 1));
            }
            deque.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
