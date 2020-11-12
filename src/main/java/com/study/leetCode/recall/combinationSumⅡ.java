package main.java.com.study.leetCode.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-40-组合总和Ⅱ
 * @date： 2020-11-12 15:50
 * 难度：中等
 * 标签：数组、回溯算法
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class combinationSumⅡ {
    /**
     * 回溯算法
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        // 关键步骤：排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(candidates);
        List<Integer> track = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, track, res, 0);
        return res;
    }

    private static void backtrack(int[] candidates, int target, List<Integer> track, List<List<Integer>> res, int begin) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < candidates.length; i++) {
            // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
            if (target - candidates[i] < 0) {
                break;
            }
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            //choose过程
            track.add(candidates[i]);
            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            backtrack(candidates, target - candidates[i], track, res, i + 1);
            //unchoose过程
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
