package main.java.com.study.leetCode.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: whb
 * @date: 2020/5/28 18:03
 * @description: LeetCode-200 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 */
public class NumIslands {
    /**
     * 求岛屿数量
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //二维网格行数
        int nr = grid.length;
        //二维网格列数
        int nc = grid[0].length;
        //岛屿数量
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    //广度优先搜索
                    bfs(grid, r, c);
                    //深度优先搜索
                    //dfs(grid, r, c);
                }
            }
        }
        return num_islands;
    }

    /**
     * 广度优先搜索
     * 线性扫描整个二维网格，如果一个结点包含 1，则以其为根结点启动广度优先搜索。将其放入队列中，并将值设为 0 以标记访问过该结点。迭代地搜索队列中的每个结点，直到队列为空。
     *
     * @param grid
     * @param r
     * @param c
     */
    private void bfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        //将原本为1的元素标记为0
        grid[r][c] = '0';
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(r * nc + c);
        while (!bfsQueue.isEmpty()) {
            int id = bfsQueue.remove();
            int row = id / nc;
            int col = id % nc;
            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                bfsQueue.add((row - 1) * nc + col);
                grid[row - 1][col] = '0';
            }
            if (row + 1 < nr && grid[row + 1][col] == '1') {
                bfsQueue.add((row + 1) * nc + col);
                grid[row + 1][col] = '0';
            }
            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                bfsQueue.add(row * nc + col - 1);
                grid[row][col - 1] = '0';
            }
            if (col + 1 < nc && grid[row][col + 1] == '1') {
                bfsQueue.add(row * nc + col + 1);
                grid[row][col + 1] = '0';
            }
        }
    }

    /**
     * 深度优先搜索
     * 线性扫描整个二维网格，如果一个结点包含 1，则以其为根结点启动深度优先搜索。在深度优先搜索过程中，每个访问过的结点被标记为 0。计数启动深度优先搜索的根结点的数量，即为岛屿的数量。
     *
     * @param grid
     * @param r
     * @param c
     */
    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        //将原本为1的元素标记为0
        grid[r][c] = '0';
        //遍历上下左右四个方向
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
