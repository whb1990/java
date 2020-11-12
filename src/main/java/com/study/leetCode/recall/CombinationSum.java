package main.java.com.study.leetCode.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-39-组合总和
 * @date： 2020-11-12 15:14
 * 难度：中等
 * 标签：数组、回溯算法
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 *
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(candidates, target, track, res, 0);
        return res;
    }

    private static void backtrack(int[] candidates, int target, List<Integer> track, List<List<Integer>> res, int begin) {
        if (begin == candidates.length) {
            return;
        }
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < candidates.length; i++) {
            // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0（因为排好序了），因此用 break
            if (target - candidates[i] < 0) {
                break;
            }
            //choose 过程
            track.add(candidates[i]);
            //进入下一次决策，注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            backtrack(candidates, target - candidates[i], track, res, i);
            //回溯unchoose过程
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
    }
}
