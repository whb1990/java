package main.java.com.study.leetCode.dp;

/**
 * @author: whb
 * @date: 2020/7/6 17:53
 * @description: LeetCode-64-最小路径和
 * 难度：中等
 * 标签：数组、动态规划
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
     * 步骤一、定义数组元素的含义
     *
     * 由于我们的目的是从左上角到右下角，最小路径和是多少，那我们就定义 dp[i] [j]的含义为：当机器人从左上角走到(i, j) 这个位置时，最小的路径和是 dp[i] [j]。那么，dp[m-1] [n-1] 就是我们要的答案了。
     *
     * 注意，这个网格相当于一个二维数组，数组是从下标为 0 开始算起的，所以 右下角的位置是 (m-1, n - 1)，所以 dp[m-1] [n-1] 就是我们要走的答案。
     *
     * 步骤二：找出关系数组元素间的关系式
     *
     * 想象以下，机器人要怎么样才能到达 (i, j) 这个位置？由于机器人可以向下走或者向右走，所以有两种方式到达
     *
     * 一种是从 (i-1, j) 这个位置走一步到达
     *
     * 一种是从(i, j - 1) 这个位置走一步到达
     *
     * 不过这次不是计算所有可能路径，而是计算哪一个路径和是最小的，那么我们要从这两种方式中，选择一种，使得dp[i] [j] 的值是最小的，显然有 dp[i] [j] = min(dp[i-1][j]，dp[i][j-1]) + grid[i][j];// grid[i][j] 表示网格种的值
     *
     * 步骤三、找出初始值
     *
     * 显然，当 dp[i] [j] 中，如果 i 或者 j 有一个为 0，那么还能使用关系式吗？答是不能的，因为这个时候把 i - 1 或者 j - 1，就变成负数了，数组就会出问题了，所以我们的初始值是计算出所有的 dp[0] [0….n-1] 和所有的 dp[0….m-1] [0]。这个还是非常容易计算的，相当于计算机图中的最上面一行和左边一列。因此初始值如下：
     *
     * dp[0] [j] = grid[0] [j] + dp[0] [j-1]; // 相当于最上面一行，机器人只能一直往左走
     *
     * dp[i] [0] = grid[i] [0] + dp[i] [0]; // 相当于最左面一列，机器人只能一直往下走
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //计算行数、列数
        int row = grid.length, col = grid[0].length;
        //定义二维数组
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //第一个位置的值 = 网格起点的值
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    //计算第一行的dp，只能向右走
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    //计算第一列的dp，只能向下走
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    //计算其他位置的dp
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
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
