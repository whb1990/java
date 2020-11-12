package main.java.com.study.leetCode.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-47-全排列Ⅱ
 * @date： 2020-11-12 11:42
 * 难度：中等
 * 标签：回溯算法
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class PermuteⅡ {
    public static List<List<Integer>> permute(int[] nums) {
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        //boolean数组用于记录哪些数字已经被选择过
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, track, res);
        return res;
    }

    private static void backtrack(int[] nums, boolean[] used, List<Integer> track, List<List<Integer>> res) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
                // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                //choose过程
                track.add(nums[i]);
                used[i] = true;
                //进入下一层决策
                backtrack(nums, used, track, res);
                // 回溯unchoose过程，和 choose的代码是对称的
                track.remove(track.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 1, 2}));
        System.out.println(permute(new int[]{3, 3, 0, 3}));
    }
}
