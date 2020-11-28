package main.java.com.study.leetCode.dp;

/**
 * @author： whb
 * @description： LeetCode-1277-统计全为1的正方形子矩阵
 * @date： 2020-11-28 14:15
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 *
 * 示例 1：
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 *
 * 示例 2：
 * 输入：matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * 输出：7
 * 解释：
 * 边长为 1 的正方形有 6 个。
 * 边长为 2 的正方形有 1 个。
 * 正方形的总数 = 6 + 1 = 7.
 *
 *
 * 提示：
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 */
public class CountSquares {
    /**
     * 动态规划
     *
     * 创一个dp数组等于matrix，和一个nums用于统计正方形个数
     * 计算正方形边长方程：
     * dp[i][j]=min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])+1
     * 该方程的含义：
     * 表示从当前可得正方形的右下角点dp[i][j]的左方，上方，以及左上三个方向取最小值+1，即为当前最大正方形的边长值(因为要取正方形的最大边长，
     * 所有边长必须相等，故一定是取三个方向的最小值，才能保证边长相等)
     *
     * 此时nums+dp[i][j],解释原因例如：
     * 如果dp[i][j]=3，那么以dp[i][j]该点为正方形的右下角，存在一个边长为3的正方形，同时，边长为3的正方形会包含一个边长比它小的正方形，
     * 故在dp[i][j]处还能取到边长为2，边长为1的正方形，故该点能取边长为 1,2,3的三个正方形，故nums+dp[i][j]
     * @param matrix
     * @return
     */
    public static int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        int res = 0;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        }));
        System.out.println(countSquares(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        }));
    }
}
