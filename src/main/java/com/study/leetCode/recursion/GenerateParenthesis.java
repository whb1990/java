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

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println(Arrays.toString(res.toArray(new String[res.size()])));
    }
}
