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
     * 构建这个一个特殊的哈希表，下标0~n-1依次对应数值0~n-1有没有出现过，如果数字x第一次出现，那么下标x 的位置的元素应该为该位置的相反值，标识这个数字x出现过，
     * 当下一次再遇到x，判断一下下标x的值是否<0，如果是的话表示之前已经访问过，就找到了这个重复的数。由于数值范围是0~n-1，对0取反还是0，难以判断是否重复，
     * 故将所有数字都加1，再进行标记。
     *
     * @param nums
     * @return
     */
    public static int finRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] + 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] *= -1;
            } else {
                return x - 1;
            }
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
