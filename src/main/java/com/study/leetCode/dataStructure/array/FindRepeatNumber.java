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
     * 如果没有重复数字，那么正常排序后，数字i应该在下标为i的位置，所以思路是重头扫描数组，遇到下标为i的数字如果不是i的话，
     * （假设为m),那么我们就拿与下标m的数字交换。在交换过程中，如果有重复的数字发生，那么终止返回结果。
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

    /**
     * 打标记法，将数组中元素减一取反来标志改位置已经遍历过，无需交换，速度更快
     *
     * @param nums
     * @return
     */
    public static int finRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 注意，必须先加1再取反，若先取反，对应nums[i]==INT_MIN的情况，就会溢出报错
            int idx = nums[i] < 0 ? -(nums[i] + 1) : nums[i];
            if (nums[idx] < 0) {
                return idx;
            }
            // 注意，必须先取反再减1，若先加1再取反，对应nums[i]==INT_MAX的情况，就会溢出报错
            nums[idx] = -nums[idx] - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findRepeatNumber(new int[]{3, 1, 3, 4, 2}));
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(findRepeatNumber(new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
        System.out.println("==========标记法=========");
        System.out.println(finRepeatNumber2(new int[]{1, 3, 4, 2, 2}));
        System.out.println(finRepeatNumber2(new int[]{3, 1, 3, 4, 2}));
        System.out.println(finRepeatNumber2(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(finRepeatNumber2(new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
    }
}
