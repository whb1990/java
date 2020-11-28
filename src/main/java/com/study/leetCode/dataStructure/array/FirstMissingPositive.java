package main.java.com.study.leetCode.dataStructure.array;

/**
 * @author： whb
 * @description： LeetCode-41-缺失的第一个正数
 * @date： 2020-11-28 9:36
 * 难度：困难
 * 标签：数组
 */
public class FirstMissingPositive {
    /**
     * 原地置换法
     * 遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置，
     * 然后再遍历一次数组查当前下标是否和值对应，
     * 如果不对应那这个下标就是答案，否则遍历完都没出现那么答案就是数组长度加1。
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}
