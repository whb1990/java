package main.java.com.study.leetCode.binarySearch;

/**
 * @author： whb
 * @description： LeetCode-240-搜索二维矩阵Ⅱ
 * @date： 2020-10-14 11:42
 * 难度：中等
 * 标签：二分查找、分治算法
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 示例:
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 */
public class SearchMatrix {
    /**
     * 首先，初始化一个指向矩阵左下角的 (row，col)指针。
     * 然后，直到找到目标并返回 true（或者指针指向矩阵维度之外的 (row，col) 为止，执行以下操作：
     * 如果当前指向的值大于目标值，则可以 “向上” 移动一行。
     * 否则，如果当前指向的值小于目标值，则可以移动一列。
     * 不难理解为什么这样做永远不会删减正确的答案；
     * 因为行是从左到右排序的，所以知道当前值右侧的每个值都较大。
     * 因此，如果当前值已经大于目标值，知道它右边的每个值会比较大。
     * 也可以对列进行非常类似的论证，因此这种搜索方式将始终在矩阵中找到目标（如果存在）。
     *这个二维数组就类似一棵排序二叉树，对于每一个数来说，上方的数都小于它，右边的数都大于它，所以把左下角作为根节点开始查找！
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(matrix, 5));
        System.out.println(searchMatrix(matrix, 20));
    }
}
