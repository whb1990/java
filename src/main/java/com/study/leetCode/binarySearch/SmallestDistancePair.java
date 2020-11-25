package main.java.com.study.leetCode.binarySearch;

import java.util.Arrays;

/**
 * @author: whb
 * @date: 2020/6/10 17:30
 * @description: LeetCode-719-找出第k小的距离对
 * 难度：困难
 * 标签：堆、数组、二分查找
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
     * 首先需要对数组排序，这样能很快找出最大距离对，也就是nums[len-1]-nums[0]，
     * 然后第k小的距离对一定会在最大和最小距离对之间，一般这种范围查找用到的就是二分查找，
     * 核心是中间那一段for循环代码，mid指的是中间的距离对的长度，left和right分别是nums上的左右指针，
     * 通过while循环来将所有<=mid的距离对的个数算出来，并加到count中，
     * 如果count>=k，那么right=mid，如果count<k，那么left=mid+1；
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
