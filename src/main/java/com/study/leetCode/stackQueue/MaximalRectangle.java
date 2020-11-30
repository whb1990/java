package main.java.com.study.leetCode.stackQueue;

/**
 * @author： whb
 * @description： LeetCode-85-最大矩形
 * @date： 2020-11-30 11:44
 * 难度：困难
 * 标签：栈、数组、哈希表、动态规划
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例 1：
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 *
 * 示例 2：
 * 输入：matrix = []
 * 输出：0
 *
 * 示例 3：
 * 输入：matrix = [["0"]]
 * 输出：0
 *
 * 示例 4：
 * 输入：matrix = [["1"]]
 * 输出：1
 *
 * 示例 5：
 * 输入：matrix = [["0","0"]]
 * 输出：0
 *
 *
 * 提示：
 * rows == matrix.length
 * cols == matrix.length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 */
public class MaximalRectangle {
    /**
     * 这一题的算法本质上和84题Largest Rectangle in Histogram一样，对每一行都求出每个元素对应的高度，这个高度就是对应的连续1的长度，
     * 然后对每一行都更新一次最大矩形面积。那么这个问题就变成了Largest Rectangle in Histogram。本质上是对矩阵中的每行，均依次执行84题算法。
     * @param matrix
     * @return
     */
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length, maxArea = 0;
        int[] heights = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                }
            }
            maxArea = Math.max(maxArea, LargestRectangleArea.largestRectangleArea(heights));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
        System.out.println(maximalRectangle(new char[][]{
                {}
        }));
        System.out.println(maximalRectangle(new char[][]{
                {'1'}
        }));
        System.out.println(maximalRectangle(new char[][]{
                {'0'}
        }));
        System.out.println(maximalRectangle(new char[][]{
                {'0', '0'}
        }));
    }
}
