package main.java.com.study.leetCode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-78-子集
 * @date： 2020-11-12 17:07
 * 难度：中等
 * 标签：回溯算法
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> track = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, track, res);
        return res;
    }

    private static void backtrack(int[] nums, int begin, List<Integer> track, List<List<Integer>> res) {
        //注意这里没有写终止条件，不是说递归一定要有终止条件的吗，这里怎么没写，其实这里的终止条件
        //隐含在for循环中了，当然也可以写if(start>nums.length) rerurn;只不过这里省略了。
        //走过的所有路径都是子集的一部分，所以都要加入到集合中
        res.add(new ArrayList<>(track));
        for (int i = begin; i < nums.length; i++) {
            //choose过程
            track.add(nums[i]);
            //进入下一步决策
            backtrack(nums, i + 1, track, res);
            //unchoose过程
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
