package main.java.com.study.leetCode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-22-括号生成
 * @date： 2020-11-11 10:54
 * 难度：中等
 * 标签：字符串、回溯算法
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class GenerateParenthesis {
    /**
     * 递归
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return Arrays.asList("");
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (String left : generateParenthesis(i)) {
                for (String right : generateParenthesis(n - i - 1)) {
                    res.add("(" + left + ")" + right);
                }
            }
        }
        return res;
    }

    /**
     * 深度优先搜索
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis2(int n) {
        // 特判
        if (n == 0) {
            return Arrays.asList("");
        }
        List<String> res = new ArrayList<>();

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private static void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println(Arrays.toString(res.toArray(new String[res.size()])));
        res = generateParenthesis2(3);
        System.out.println(Arrays.toString(res.toArray(new String[res.size()])));
    }
}
