package main.java.com.study.leetCode.binarySearch;

import java.util.Arrays;

/**
 * @author: whb
 * @date: 2020/3/18 16:28
 * @description: LeetCode-34-在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {
        //初始化结果集
        int[] result = new int[]{
                -1, -1
        };
        //先查目标值在数组中的开始位置
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] >= target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (left < nums.length && nums[left] == target) {
            result[0] = left;
        }
        //如果开始位置都不存在，说明目标值在数组中不存在，否则查目标值的结束位置
        if (result[0] != -1) {
            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (nums[middle] <= target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            if (right >= 0 && nums[right] == target) {
                result[1] = right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 9)));
    }
}
