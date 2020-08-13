package main.java.com.study.leetCode.dataStructure.array;

/**
 * @author: whb
 * @date: 2020/8/13 14:04
 * @description: LeetCode-剑指Offer03.数组中的重复数字
 * 难度：简单
 * 标签：数组、哈希表
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 限制：
 * 2 <= n <= 100000
 */
public class FindRepeatNumber {
    /**
     * 原地置换
     * 重排数组：把扫描的每个数字（如数字m）放到其对应下标（m下标）的位置上，若同一位置有重复，则说明该数字重复。
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findRepeatNumber(new int[]{3, 1, 3, 4, 2}));
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(findRepeatNumber(new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
    }
}
