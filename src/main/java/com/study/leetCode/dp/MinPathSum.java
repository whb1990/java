package main.java.com.study.leetCode.dp;

/**
 * @author: whb
 * @date: 2020/7/6 17:53
 * @description: LeetCode-64-最小路径和
 * 难度：中等
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum {
    /**
     * 动态规划-二维数组解法
     * 用一个同样大小的二维数组dp来存储走到每个位置上最小的和。
     * dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        //计算行数、列数
        int row = grid.length, col = grid[0].length;
        //定义二维数组
        int[][] dp = new int[row][col];
        //第一个位置的值 = 网格起点的值
        dp[0][0] = grid[0][0];
        //计算第一列的dp，只能向下走
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //计算第一行的dp，只能向右走
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        //计算其他位置的dp
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        //返回最后结果
        return dp[row - 1][col - 1];
    }

    /**
     * 动态规划-一维数组解法
     * 解法1中使用dp数组的空间大小为M*N，其实可以对dp数组的空间压缩至N，定义大小为N的dp数组，
     * 对于第一行，dp[i]=dp[i-1]+m[0][i],在求第二行中的 dp[i] 时可以覆盖第一行 dp[i] ,第二行dp[i]=Math.min（dp[i],dp[i-1]）+m[i][j]。
     *
     * @param grid
     * @return
     */
    public static int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int j = 1; j < grid[0].length; j++) {
            //求出第一行的dp
            dp[j] = dp[j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[0] = grid[i][0] + dp[0];
            //dp[0]代表每一行最左边的dp，
            //后一行的dp覆盖前一行的dp
            for (int j = 1; j < grid[0].length; j++) {
                dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]);
            }
        }
        return dp[grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
        System.out.println(minPathSum2(grid));
    }
}
