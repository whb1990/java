package main.java.com.study.leetCode.binarySearch;

import java.util.PriorityQueue;

/**
 * @author: whb
 * @date: 2020/7/2 18:38
 * @description: LeetCode-378-有序矩阵第k小的元素
 * 难度：中等
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 * 示例：
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 */
public class KthSmallest {
    /**
     * 堆排序解法
     *
     * @param matrix
     * @param k
     * @return
     */
    public static int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || k < 0) {
            return -1;
        }
        /**
         * 构建小顶堆
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return a - b;
        });
        for (int[] arr : matrix) {
            for (int num : arr) {
                queue.add(num);
            }
        }
        //先弹出前k-1个元素
        while (k-- > 1) {
            queue.remove();
        }
        //返回第k个元素作为结果
        return queue.remove();
    }
}
