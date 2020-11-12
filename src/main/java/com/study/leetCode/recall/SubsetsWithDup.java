package main.java.com.study.leetCode.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-90-子集Ⅱ
 * @date： 2020-11-12 17:21
 * 难度：中等
 * 标签：回溯算法
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubsetsWithDup {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        //排序是关键-->剪枝
        Arrays.sort(nums);
        List<Integer> track = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, track, res);
        return res;
    }

    private static void backtrack(int[] nums, int begin, List<Integer> track, List<List<Integer>> res) {
        if (begin > nums.length) {
            return;
        }
        //走过的所有路径都是子集的一部分，所以都要加入到集合中
        res.add(new ArrayList<>(track));
        for (int i = begin; i < nums.length; i++) {
            // 剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, i + 1, track, res);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }
}
