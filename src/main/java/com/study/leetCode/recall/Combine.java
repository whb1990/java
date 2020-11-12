package main.java.com.study.leetCode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-77-组合
 * @date： 2020-11-12 16:27
 * 难度：中等
 * 标签：回溯算法
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combine {
    public static List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        // 从 1 开始是题目的设定
        backtrack(n, k, 1, track, res);
        return res;
    }

    private static void backtrack(int n, int k, int begin, List<Integer> track, List<List<Integer>> res) {
        // 递归终止条件是：track 的长度等于 k
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        // 遍历可能的搜索起点
        for (int i = begin; i <= n - (k - track.size()) + 1; i++) {
            // choose过程，往决策路径添加一个数
            track.add(i);
            //进入下一步决策，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            backtrack(n, k, i + 1, track, res);
            //回溯unchoose过程
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
