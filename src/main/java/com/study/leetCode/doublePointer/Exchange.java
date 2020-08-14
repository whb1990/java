package main.java.com.study.leetCode.doublePointer;

import java.util.Arrays;

/**
 * @author: whb
 * @date: 2020/8/7 2:04
 * @description: LeetCode-剑指Offer21.调整数组顺序使奇数位于偶数前面
 * 难度：简单
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class Exchange {
    /**
     * 双指针解法
     * 解题思路：
     * 考虑定义双指针 i , j 分列数组左右两端，循环执行：
     * <p>
     * 1、指针 i 从左向右寻找偶数；
     * 2、指针 j 从右向左寻找奇数；
     * 3、将 偶数 nums[i] 和 奇数nums[j] 交换。
     * 可始终保证： 指针 i 左边都是奇数，指针 j 右边都是偶数 。
     * <p>
     * 算法流程：
     * 1、初始化： i , j 双指针，分别指向数组 nums 左右两端；
     * 2、循环交换： 当 i=j 时跳出；
     * 2.1、指针 i 遇到奇数则执行 i=i+1 跳过，直到找到偶数；
     * 2.2、指针 j 遇到偶数则执行 j=j−1 跳过，直到找到奇数；
     * 2.3、交换 nums[i] 和 nums[j] 值；
     * 3、返回值： 返回已修改的 nums 数组。
     * <p>
     * 复杂度分析：
     * 时间复杂度 O(N) ： N 为数组 nums 长度，双指针 i, j 共同遍历整个数组。
     * 空间复杂度 O(1) ： 双指针 i, j 使用常数大小的额外空间。
     *
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            //x&1 位运算 等价于 x%2 取余运算，即皆可用于判断数字奇偶性。
            while (i < j && (nums[i] & 1) == 1) {
                i++;
            }
            while (i < j && (nums[j] & 1) == 0) {
                j--;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
    }
}
