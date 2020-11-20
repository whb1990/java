package main.java.com.study.leetCode.recall;

import main.java.com.study.leetCode.CommonUtils;

/**
 * @author： whb
 * @description： LeetCode-37-解数独
 * @date： 2020-11-20 8:23
 * 难度：困难
 * 标签：哈希表、回溯算法
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * 提示：
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 */
public class SolveSudoku {
    /**
     * 采用回溯算法
     *
     * @param board
     */
    public static void solveSudoku(char[][] board) {
        System.out.println("=====解数独之前的数独：=========");
        CommonUtils.printChar2Arr(board);
        backtrack(board, 0, 0);
        System.out.println("+++++++++解数独之后的数独：+++++++++++++++");
        CommonUtils.printChar2Arr(board);
    }

    /**
     * 注意这里的参数，row表示第几行，col表示第几列。
     *
     * @param board
     * @param row
     * @param col
     * @return
     */
    private static boolean backtrack(char[][] board, int row, int col) {
        //注意row是从0开始的，当row等于board.length的时候表示数独的
        //最后一行全部读遍历完了，说明数独中的值是有效的，直接返回true
        if (row == board.length) {
            return true;
        }
        //如果当前行的最后一列也遍历完了，就从下一行的第一列开始。这里的遍历
        //顺序是从第1行的第1列一直到最后一列，然后第二行的第一列一直到最后
        //一列，然后第三行的……
        if (col == board.length) {
            return backtrack(board, row + 1, 0);
        }

        if (board[row][col] != '.') {
            return backtrack(board, row, col + 1);
        }
        //如果上面条件都不满足，就从1到9种选择一个合适的数字填入到数独中
        for (char ch = '1'; ch <= '9'; ch++) {
            //判断当前位置[row，col]是否可以放数字i，如果不能放再判断下
            //一个能不能放，直到找到能放的为止，如果从1-9都不能放，就会下面
            //直接return false
            if (!isValid(board, row, col, ch)) {
                continue;
            }
            //如果能放数字ch，就把数字ch放进去
            board[row][col] = ch;
            //如果成功就直接返回，不需要再尝试了
            if (backtrack(board, row, col + 1)) {
                return true;
            }
            //否则就撤销重新选择
            board[row][col] = '.';
        }
        //如果当前位置[row，col]不能放任何数字，直接返回false
        return false;
    }

    /**
     * 验证当前位置[row，col]是否可以存放字符c
     *
     * @param board
     * @param row
     * @param col
     * @param ch
     * @return
     */
    private static boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < board.length; i++) {
            //当前行有没有和字符ch重复的
            if (board[row][i] == ch) {
                return false;
            }
            //当前列有没有和字符ch重复的
            if (board[i][col] == ch) {
                return false;
            }
            //当前的单元格内是否有和字符ch重复的
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == ch) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
    }
}
