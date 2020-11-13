package main.java.com.study.leetCode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-51-N皇后
 * @date： 2020-11-13 14:19
 * 难度：困难
 * 标签：回溯算法
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *
 *
 * 示例：
 * 输入：4
 * 输出：[
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 *
 * 提示：
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 */
public class SolveNQueens {
    public static List<List<String>> solveNQueens(int n) {
        char[][] track = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                track[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(0, track, res);
        return res;
    }

    private static void backtrack(int row, char[][] track, List<List<String>> res) {
        //终止条件，最后一行都走完了，说明找到了一组，把它加入到集合res中
        if (row == track.length) {
            res.add(convertToList(track));
            return;
        }
        //遍历每一行
        for (int col = 0; col < track.length; col++) {
            //如果选择的这个位置会被攻击，则跳过
            if (!isValid(track, row, col)) {
                continue;
            }
            //choose过程
            track[row][col] = 'Q';
            //进入下一次决策
            backtrack(row + 1, track, res);
            //unchoose过程
            track[row][col] = '.';
        }
    }

    /**
     * 判断网格中是否可以放置Q
     *
     * @param track
     * @param row
     * @param col
     * @return
     */
    private static boolean isValid(char[][] track, int row, int col) {
        //检查正上方
        for (int i = 0; i < row; i++) {
            if (track[i][col] == 'Q') {
                return false;
            }
        }
        //检查右斜上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < track.length; i--, j++) {
            if (track[i][j] == 'Q') {
                return false;
            }
        }
        //检查左斜上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (track[i][j] == 'Q') {
                return false;
            }
        }
        //不用检查下方，因为下方还没有放皇后
        return true;
    }

    /**
     * 数组转List
     *
     * @param track
     * @return
     */
    private static List<String> convertToList(char[][] track) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < track.length; i++) {
            path.add(new String(track[i]));
        }
        return path;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
        System.out.println(solveNQueens(8));
    }
}
