package main.java.com.study.leetCode.dataStructure.dfsbfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: whb
 * @date: 2020/8/11 10:08
 * @description: LeetCode-130-被围绕的区域
 * 难度：中等
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * 解题思路：
 * 本题给定的矩阵中有三种元素：
 * 字母 X；
 * 被字母 X 包围的字母 O；
 * 没有被字母 X 包围的字母 O。
 * <p>
 * 本题要求将所有被字母 X 包围的字母 O都变为字母 X ，但很难判断哪些 O 是被包围的，哪些 O 不是被包围的。
 * 注意到题目解释中提到：任何边界上的 O 都不会被填充为 X。 我们可以想到，所有的不被包围的 O 都直接或间接与边界上的 O 相连。我们可以利用这个性质判断 O 是否在边界上，具体地说：
 * 对于每一个边界上的 O，我们以它为起点，标记所有与它直接或间接相连的字母 O；
 * 最后我们遍历这个矩阵，对于每一个字母：
 * 如果该字母被标记过，则该字母为没有被字母 X 包围的字母 O，我们将其还原为字母 O；
 * 如果该字母没有被标记过，则该字母为被字母 X 包围的字母 O，我们将其修改为字母 X。
 */
public class Solve {

    public static void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int nr = board.length, nc = board[0].length;
        //处理行的边界
        for (int i = 0; i < nr; i++) {
            //dfs(board, i, 0);
            //dfs(board, i, nc - 1);
            bfs(board, i, 0);
            bfs(board, i, nc - 1);
        }
        //处理列的边界（注意是1~nc-1，原因的0和nc-1在处理行边界时已经处理过了）
        for (int j = 1; j < nc - 1; j++) {
            //dfs(board, 0, j);
            //dfs(board, nr - 1, j);
            bfs(board, 0, j);
            bfs(board, nr - 1, j);
        }
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for (char[] arr : board) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 深度优先搜索
     * 可以使用深度优先搜索实现标记操作。把标记过的字母 O 修改为字母 A
     * 时间复杂度：O(n×m)，其中 n 和 m 分别为矩阵的行数和列数。深度优先搜索过程中，每一个点至多只会被标记一次。
     * <p>
     * 空间复杂度：O(n×m)，其中 n 和 m 分别为矩阵的行数和列数。主要为深度优先搜索的栈的开销。
     *
     * @param board
     */
    private static void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

    /**
     * 广度优先搜索
     * 可以使用广度优先搜索实现标记操作。把标记过的字母 O 修改为字母 A
     * 时间复杂度：O(n×m)，其中 n 和 m 分别为矩阵的行数和列数。广度优先搜索过程中，每一个点至多只会被标记一次。
     * <p>
     * 空间复杂度：O(n×m)，其中 n 和 m 分别为矩阵的行数和列数。主要为广度优先搜索的队列的开销。
     *
     * @param board
     */
    private static void bfs(char[][] board, int i, int j) {
        int nr = board.length, nc = board[0].length;
        if (i < 0 || j < 0 || i >= nr || j >= nc || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * nc + j);
        while (!queue.isEmpty()) {
            int id = queue.poll();
            int row = id / nc;
            int col = id % nc;
            if (row - 1 >= 0 && board[row - 1][col] == 'O') {
                board[row - 1][col] = 'A';
                queue.offer((row - 1) * nc + col);
            }
            if (row + 1 < nr && board[row + 1][col] == 'O') {
                board[row + 1][col] = 'A';
                queue.offer((row + 1) * nc + col);
            }
            if (col - 1 >= 0 && board[row][col - 1] == 'O') {
                board[row][col - 1] = 'A';
                queue.offer(row * nc + col - 1);
            }
            if (col + 1 < nc && board[row][col + 1] == 'O') {
                board[row][col + 1] = 'A';
                queue.offer(row * nc + col + 1);
            }
        }
    }

    public static void main(String[] args) {
        solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
    }
}
