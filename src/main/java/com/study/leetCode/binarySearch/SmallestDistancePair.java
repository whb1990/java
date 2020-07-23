package main.java.com.study.leetCode.binarySearch;

import java.util.Arrays;

/**
 * @author: whb
 * @date: 2020/6/10 17:30
 * @description: LeetCode-719-找出第k小的距离对
 * 难度：困难
 * 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。
 * <p>
 * 示例 1:
 * 输入：
 * nums = [1,3,1]
 * k = 1
 * 输出：0
 * 解释：
 * 所有数对如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
 * <p>
 * 提示:
 * 2 <= len(nums) <= 10000.
 * 0 <= nums[i] < 1000000.
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 */
public class SmallestDistancePair {

    /**
     * 二分搜索+二分猜数字
     *
     * @param nums
     * @param k
     * @return
     */
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.parallelSort(nums);
        int low = 0, high = nums[nums.length - 1] - nums[0];
        while (low < high) {
            int middle = low + (high - low) / 2;
            int left = 0, count = 0;
            for (int right = 0; right < nums.length; ++right) {
                while (nums[right] - nums[left] > middle) {
                    left++;
                }
                count += right - left;
            }
            if (count >= k) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(smallestDistancePair(new int[]{1, 3, 1}, 1));
    }
}
