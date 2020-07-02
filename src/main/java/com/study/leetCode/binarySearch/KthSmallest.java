package main.java.com.study.leetCode.binarySearch;

import java.util.PriorityQueue;

/**
 * @author: whb
 * @date: 2020/7/2 18:38
 * @description: LeetCode-378-有序矩阵第k小的元素
 * 难度：中等
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * <p>
 * 示例：
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
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

    /**
     * 二分查找解法
     * 1.找出二维矩阵中最小的数left，最大的数right，那么第k小的数必定在left~right之间；
     * 2.mid = (left + right) / 2，在二维矩阵中找小于等于mid的元素个数count；
     * 3.若这个count小于k，表明第k小的数在右半部分且不包含mid，即left = mid + 1,right = right，又保证了第k小的数在left~right之间；
     * 4、若这个count大于k，表明第k小的数在左半部分且可能包含mid，即left = left, right = mid，又保证了第k小的数在left~right之间；
     * 5.因为每次循环中都保证了第k小的数在left~right之间，当left == right，第k小的数即被找出来，等于right。
     * 注意：left、mid、right是数值，不是索引位置。
     *
     * @param matrix
     * @param k
     * @return
     */
    public static int kthSmallestBS(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];
        while (left < right) {
            //每次循环都保证第k小的数在start~end之间，当start == end时，第k小的数就是start
            int mid = (left + right) / 2;
            //找出二维矩阵中 <= mid的元素个数
            int count = findNotBiggerThanMid(matrix, mid, row, col);
            if (count < k) {
                //第k小的数在右半部分，且不包含mid
                left = mid + 1;
            } else {
                //第k小的数在左半部分，可能包含mid
                right = mid;
            }
        }
        return right;
    }

    private static int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        //以列为单位找，找到每一列最后一个 <= mid的数即可知道每一列有多少个数 <= mid
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                //第j列有i+1个元素 <= mid
                count += i + 1;
                j++;
            } else {
                //第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
        System.out.println(kthSmallestBS(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
    }
}
