package main.java.com.study.leetCode.sort;

import java.util.Arrays;

/**
 * @author: whb
 * @date: 2019/10/15 10:33
 * @description: LeetCode-75-颜色分类-荷兰国旗问题
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class SortColors {

    public static int[] sortColors(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) {
                swap(nums, --two, one);
            } else {
                ++one;
            }
        }
        return nums;
    }

    /**
     * 用三个指针（p0, p2 和curr）来分别追踪0的最右边界，2的最左边界和当前考虑的元素。
     * 沿着数组移动 curr 指针，若nums[curr] = 0，则将其与 nums[p0]互换；若 nums[curr] = 2 ，则与 nums[p2]互换。
     * 算法
     * <p>
     * 初始化0的最右边界：p0 = 0。在整个算法执行过程中 nums[idx < p0] = 0.
     * <p>
     * 初始化2的最左边界 ：p2 = n - 1。在整个算法执行过程中 nums[idx > p2] = 2.
     * <p>
     * 初始化当前考虑的元素序号 ：curr = 0.
     * <p>
     * While curr <= p2 :
     * <p>
     * 若 nums[curr] = 0 ：交换第 curr个 和 第p0个 元素，并将指针都向右移。
     * <p>
     * 若 nums[curr] = 2 ：交换第 curr个和第 p2个元素，并将 p2指针左移 。
     * <p>
     * 若 nums[curr] = 1 ：将指针curr右移。
     *
     * @param nums
     * @return
     */
    public static int[] sortColors2(int[] nums) {
        int p0 = 0, cur = 0, p2 = nums.length - 1;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                swap(nums, p0++, cur++);
            } else if (nums[cur] == 2) {
                swap(nums, p2--, cur);
            } else {
                cur++;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(sortColors2(nums)));
    }
}
