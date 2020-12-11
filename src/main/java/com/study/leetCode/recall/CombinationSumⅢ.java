package main.java.com.study.leetCode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-216-组合总和Ⅲ
 * @date： 2020-11-13 9:12
 * 难度：中等
 * 标签：数组、回溯算法
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 *
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumⅢ {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0) {
            return new ArrayList<>();
        }
        List<Integer> track = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, 1, track, res);
        return res;
    }

    private static void backtrack(int n, int k, int begin, List<Integer> track, List<List<Integer>> res) {
        // 1.终止条件，如果满足这个条件，再往下找也没什么意义了
        if (track.size() == k || n <= 0) {
            //如果找到一组合适的就把他加入到集合list中
            if (track.size() == k && n == 0) {
                res.add(new ArrayList<>(track));
            }
            return;
        }
        // 2.选择列表，因为不能有重复的集合以及集合中不能有重复的数字，所以这里的i不能从0开始，
        // 要从上一个选择之后的下一个值开始
        for (int i = begin; i <= 9; i++) {
            // 大剪枝
            if (n - i < 0) {
                break;
            }
            // 选择
            track.add(i);
            // 递归
            backtrack(n - i, k, i + 1, track, res);
            //撤销选择
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
    }
}
