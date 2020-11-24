package main.java.com.study.leetCode.stackQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author： whb
 * @description： LeetCode-321-拼接最大数
 * @date： 2020-10-29 17:56
 * 难度：困难
 * 标签：栈、贪心算法、动态规划
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * <p>
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * <p>
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * <p>
 * 示例 1:
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * <p>
 * 示例 2:
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * <p>
 * 示例 3:
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 */
public class MaxNumber {
    /**
     * 1、假设最终结果有count个数（介于0～k之间）字在nums1中，那么有（k-count）个数字在nums2中，最外层循环遍历0到count的情况。不一定从0开始，若nums2个数不足k个，则从（k-nums2.length）开始。同样，不一定在count结束，若nums1个数不足k个，则在nums1.length结束。
     * 2、分别从nums1、nums2取最大子序列。可以借助栈来获取最大子序列，注意只有当数组剩余元素多余栈中剩余空间时，才能将栈中较小的元素出栈。
     * 3、合并两个子序列组成一个序列。可以借助双指针从头递进比较序列元素大小，注意比较时不能仅比较当前索引出元素，需按大数比较。
     * 4、比较合并后序列的大小是否大于已缓存的答案序列的大小，取大的作为答案序列。
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
            int[] arr = mergeArr(pickMaxArr(nums1, i), pickMaxArr(nums2, k - i), k);
            if (gt(arr, 0, res, 0)) {
                res = arr;
            }
        }
        return res;
    }

    /**
     * 从数组中选出长度为k的子序列，采用单调栈+贪心算法
     *
     * @param nums
     * @param k
     * @return
     */
    private static int[] pickMaxArr(int[] nums, int k) {
        if (k == 0) {
            return new int[k];
        }
        //单调递减栈
        Stack<Integer> stack = new Stack<>();
        int remain = nums.length - k;
        for (int num : nums) {
            while (remain > 0 && !stack.isEmpty() && num > stack.peek()) {
                stack.pop();
                remain--;
            }
            stack.push(num);
        }
        while (remain > 0) {
            stack.pop();
            remain--;
        }
        int[] res = new int[k];
        while (!stack.isEmpty()) {
            //数组单调递减
            res[--k] = stack.pop();
        }
        return res;
    }

    /**
     * 合并两个数组，降序
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    private static int[] mergeArr(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int i = 0, j = 0, idx = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                res[idx++] = nums2[j++];
            } else {
                res[idx++] = nums1[i++];
            }
        }
        while (i < nums1.length) {
            res[idx++] = nums1[i++];
        }
        while (j < nums2.length) {
            res[idx++] = nums2[j++];
        }
        return res;
    }

    /**
     * 比较nums1是否比nums2大
     *
     * @param nums1
     * @param i
     * @param nums2
     * @param j
     * @return
     */
    private static boolean gt(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
        //System.out.println(Arrays.toString(maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5)));
        //System.out.println(Arrays.toString(maxNumber(new int[]{3, 9}, new int[]{8, 9}, 3)));
    }
}
