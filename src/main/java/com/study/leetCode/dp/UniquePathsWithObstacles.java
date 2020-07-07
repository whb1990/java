package main.java.com.study.leetCode.dp;

/**
 * @author: whb
 * @date: 2020/7/7 15:34
 * @description: LeetCode-63-不同路径Ⅱ
 * 难度：中等
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class UniquePathsWithObstacles {
    /**
     * 动态规划
     * 每到一个点只能由左边或者上面过来，那么就形成两种状态。
     * 状态表示：dp [ i ] [ j ] 表示所有从起点走到（i , j）的路线数量，状态转移由两部分相加，然后注意处理边界就好。
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        //第一列
        for (int i = 0; i < row; i++) {
            //如果遇到障碍就返回
            if (obstacleGrid[i][0] != 0) {
                break;
            }
            //否则第一列有一种走法
            dp[i][0] = 1;
        }
        //第一行
        for (int j = 0; j < col; j++) {
            //如果遇到障碍就返回
            if (obstacleGrid[0][j] != 0) {
                break;
            }
            //否则第一行只有一种走法
            dp[0][j] = 1;
        }
        //其他行与列
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] != 0) {
                    //遇到障碍则走法为0
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(grid));
    }
}
