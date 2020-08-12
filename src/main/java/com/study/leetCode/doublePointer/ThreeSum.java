package main.java.com.study.leetCode.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: whb
 * @date: 2020/8/12 10:09
 * @description: LeetCode-15-三数之和
 * 难度：中等
 * 标签：数组、双指针
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    /**
     * 1、 首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，
     * 数字分别为 nums[start] 和 nums[end]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集。
     * 2、如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
     * 3、如果 nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
     * 4、当 sum == 0 时，nums[start] == nums[start+1] 则会导致结果重复，应该跳过，start++
     * 5、当 sum == 0 时，nums[end] == nums[end−1] 则会导致结果重复，应该跳过，end−−
     * 时间复杂度：O(n^2)，n 为数组长度
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        //排序数组
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (nums[i] > 0) {
                break;
            }
            //避免重复三元组
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    //避免重复三元组
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    //避免重复三元组
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
