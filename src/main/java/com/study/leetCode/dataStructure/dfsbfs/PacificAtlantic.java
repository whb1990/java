package main.java.com.study.leetCode.dataStructure.dfsbfs;

import java.util.*;

/**
 * @author： whb
 * @description： LeetCode-417-太平洋大西洋水流问题
 * @date： 2020-12-01 16:16
 * 难度：中等
 * 标签：深度优先搜索、广度优先搜索
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 *
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 *
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 *
 *
 * 提示：
 *
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 *
 *
 * 示例：
 *
 *
 * 给定下面的 5x5 矩阵:
 *
 *   太平洋 ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * 大西洋
 *
 * 返回:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 */
public class PacificAtlantic {
    /**
     * 深度优先搜索
     * 思路是从海洋开始逆流（就是从边界开始搜索） 如果可以逆流到 就标记为1 然后检查两个海洋都可以逆流到的区域
     *
     * @param matrix
     * @return
     */
    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        int row = matrix.length, col = matrix[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] can_reach_p = new boolean[row][col];
        boolean[][] can_reach_a = new boolean[row][col];
        //从海洋边界开始
        for (int i = 0; i < row; i++) {
            dfs(matrix, i, 0, matrix[i][0], can_reach_p);
            dfs(matrix, i, col - 1, matrix[i][col - 1], can_reach_a);
        }
        //从海洋边界开始
        for (int j = 0; j < col; j++) {
            dfs(matrix, 0, j, matrix[0][j], can_reach_p);
            dfs(matrix, row - 1, j, matrix[row - 1][j], can_reach_a);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (can_reach_p[i][j] && can_reach_a[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] matrix, int r, int c, int pre, boolean[][] can_reach) {
        int row = matrix.length, col = matrix[0].length;
        if (r < 0 || r >= row || c < 0 || c >= col || can_reach[r][c] || matrix[r][c] < pre) {
            return;
        }
        can_reach[r][c] = true;
        dfs(matrix, r - 1, c, matrix[r][c], can_reach);
        dfs(matrix, r + 1, c, matrix[r][c], can_reach);
        dfs(matrix, r, c - 1, matrix[r][c], can_reach);
        dfs(matrix, r, c + 1, matrix[r][c], can_reach);
    }

    /**
     * 广度优先搜索
     *
     * @param matrix
     * @return
     */
    public static List<List<Integer>> pacificAtlanticBfs(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        int[][] pacificAux = new int[m][n];
        int[][] atlanticAux = new int[m][n];

        //从海洋边界开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    pacificQueue.add(new int[]{i, j});
                }
                if (i == m - 1 || j == n - 1) {
                    atlanticQueue.add(new int[]{i, j});
                }
            }
        }

        bfs(matrix, pacificAux, pacificQueue);
        bfs(matrix, atlanticAux, atlanticQueue);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificAux[i][j] == 1 && atlanticAux[i][j] == 1) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private static void bfs(int[][] matrix, int[][] aux, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] array = queue.remove();
            int i = array[0];
            int j = array[1];
            //流到的区域就置为1
            aux[i][j] = 1;
            if (i - 1 >= 0 && matrix[i][j] <= matrix[i - 1][j] && aux[i - 1][j] != 1) {
                queue.add(new int[]{i - 1, j});
            }
            if (i + 1 < matrix.length && matrix[i][j] <= matrix[i + 1][j] && aux[i + 1][j] != 1) {
                queue.add(new int[]{i + 1, j});
            }
            if (j - 1 >= 0 && matrix[i][j] <= matrix[i][j - 1] && aux[i][j - 1] != 1) {
                queue.add(new int[]{i, j - 1});
            }
            if (j + 1 < matrix[0].length && matrix[i][j] <= matrix[i][j + 1] && aux[i][j + 1] != 1) {
                queue.add(new int[]{i, j + 1});
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));
        System.out.println(pacificAtlanticBfs(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));
    }
}
