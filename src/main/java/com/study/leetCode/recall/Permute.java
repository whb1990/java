package main.java.com.study.leetCode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-46-全排列
 * @date： 2020-11-12 11:16
 * 难度：中等
 * 标签：回溯算法
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permute {
    /**
     * 回溯算法
     * 下面给出回溯算法的模版，套用模版即可
     * """
     * choiceList：当前可以进行的选择列表
     * track：可以理解为决策路径，即已经做出一系列选择
     * answer：用来储存符合条件的决策路径
     * """
     *
     * def backtrack(choiceList, track, answer):
     *     if track is OK:
     *         answer.add(track)
     *     else:
     *         for choice in choiceList:
     *             # choose：选择一个 choice 加入 track
     *             backtrack(choices, track, answer)
     *             # unchoose：从 track 中撤销上面的选择
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(nums, track, res);
        return res;
    }

    public static void backtrack(int[] nums, List<Integer> track, List<List<Integer>> res) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
        } else {
            for (int i = 0; i < nums.length; i++) {
                //决策路径中已经存在的元素不能再被选择
                if (track.contains(nums[i])) {
                    continue;
                }
                //choose过程
                track.add(nums[i]);
                //进入下一步决策
                backtrack(nums, track, res);
                //回溯unchoose过程
                track.remove(track.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
