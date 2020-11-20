package main.java.com.study.leetCode.recall;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-1079-活字印刷
 * @date： 2020-11-20 9:35
 * 难度：中等
 * 标签：回溯算法
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 *
 * 注意：本题中，每个活字字模只能使用一次。
 *
 *
 *
 * 示例 1：
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 *
 * 示例 2：
 * 输入："AAABBC"
 * 输出：188
 *
 *
 * 提示：
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 */
public class NumTilePossibilities {
    int res = 0;

    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        for (int i = 1; i <= chars.length; i++) {
            backtrack(chars, 0, i, visited);
        }
        return res;
    }

    private void backtrack(char[] chars, int current, int target, boolean[] visited) {
        if (current == target) {
            res++;
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            backtrack(chars, current + 1, target, visited);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        NumTilePossibilities obj = new NumTilePossibilities();
        System.out.println(obj.numTilePossibilities("AAB"));
        obj.res = 0;
        System.out.println(obj.numTilePossibilities("AAABBC"));
    }
}
