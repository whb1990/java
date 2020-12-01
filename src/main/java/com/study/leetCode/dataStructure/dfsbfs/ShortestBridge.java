package main.java.com.study.leetCode.dataStructure.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author： whb
 * @description： LeetCode-934-最短的桥
 * @date： 2020-12-01 17:23
 * 难度：中等
 * 标签：深度优先搜索、广度优先搜索
 * 在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 *
 * 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
 *
 * 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
 *
 * 示例 1：
 * 输入：[[0,1],[1,0]]
 * 输出：1
 *
 * 示例 2：
 * 输入：[[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 *
 * 示例 3：
 * 输入：[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 *
 * 提示：
 * 1 <= A.length = A[0].length <= 100
 * A[i][j] == 0 或 A[i][j] == 1
 */
public class ShortestBridge {
    /**
     * 思路: DFS + BFS
     * 1、先用深度优先搜索DFS, 找到第1个岛屿, 将岛屿元素置为2, 并入队；
     * 2、再用广度优先搜索BFS, 从第1个岛屿元素开始向外寻找, 找到的0置为2；
     * 3、当找到第一个1时, 就返回寻找的路径step；
     *
     * @param A
     * @return
     */
    public static int shortestBridge(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        //是否找到第一个岛屿
        boolean findFirst = false;
        int row = A.length, col = A[0].length;
        Queue<int[]> queue = new LinkedList<>();
        //DFS第一个岛屿
        for (int i = 0; i < row; i++) {
            //只寻找第一个岛屿
            if (findFirst) {
                break;
            }
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1) {
                    dfs(A, queue, i, j);
                    //只寻找第一个岛屿
                    findFirst = true;
                    break;
                }
            }
        }
        //BFS 第一个岛屿向外扩散
        int step = 0;
        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            while (size-- > 0) {
                int[] arr = queue.poll();
                int i = arr[0], j = arr[1];
                //上下左右扩散
                if (i - 1 >= 0) {
                    if (A[i - 1][j] == 2) {
                        continue;
                    }
                    //找到另一岛屿时, 返回step
                    if (A[i - 1][j] == 1) {
                        return step;
                    }
                    //将扩散到的0置为2, 并入队
                    queue.offer(new int[]{i - 1, j});
                    A[i - 1][j] = 2;
                }
                if (i + 1 < row) {
                    if (A[i + 1][j] == 2) {
                        continue;
                    }
                    //找到另一岛屿时, 返回step
                    if (A[i + 1][j] == 1) {
                        return step;
                    }
                    //将扩散到的0置为2, 并入队
                    queue.offer(new int[]{i + 1, j});
                    A[i + 1][j] = 2;
                }
                if (j - 1 >= 0) {
                    if (A[i][j - 1] == 2) {
                        continue;
                    }
                    //找到另一岛屿时, 返回step
                    if (A[i][j - 1] == 1) {
                        return step;
                    }
                    //将扩散到的0置为2, 并入队
                    queue.offer(new int[]{i, j - 1});
                    A[i][j - 1] = 2;
                }
                if (j + 1 < col) {
                    if (A[i][j + 1] == 2) {
                        continue;
                    }
                    //找到另一岛屿时, 返回step
                    if (A[i][j + 1] == 1) {
                        return step;
                    }
                    //将扩散到的0置为2, 并入队
                    queue.offer(new int[]{i, j + 1});
                    A[i][j + 1] = 2;
                }
            }
        }
        return 0;
    }

    /**
     * DFS 寻找第一个岛屿元素
     *
     * @param A
     * @param queue
     * @param r
     * @param c
     */
    private static void dfs(int[][] A, Queue<int[]> queue, int r, int c) {
        if (r < 0 || r >= A.length || c < 0 || c >= A[0].length || A[r][c] == 2) {
            return;
        }
        if (A[r][c] == 0) {
            queue.offer(new int[]{r, c});
            return;
        }
        A[r][c] = 2;
        dfs(A, queue, r - 1, c);
        dfs(A, queue, r + 1, c);
        dfs(A, queue, r, c - 1);
        dfs(A, queue, r, c + 1);
    }

    public static void main(String[] args) {
        System.out.println(shortestBridge(new int[][]{
                {0, 1},
                {1, 0}
        }));
        System.out.println(shortestBridge(new int[][]{
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 1}
        }));
        System.out.println(shortestBridge(new int[][]{
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        }));
    }
}
