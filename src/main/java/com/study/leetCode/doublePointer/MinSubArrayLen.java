package main.java.com.study.leetCode.doublePointer;

/**
 * @author: whb
 * @date: 2020/6/4 15:43
 * @description: LeetCode-209-长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例:
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class MinSubArrayLen {
    /**
     * 采用快慢指针法进行求解，利用双指针维护一个滑动窗口，当窗口内的子数组和大于s时就向前移动慢指针，当小于s时就向前移动快指针。
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int result = nums.length + 1, sum = 0, slow = 0, fast = 0;
        while (fast < nums.length) {
            while (sum < s && fast < nums.length) {
                //滑动窗口子数据和小于目标值时向右滑动快指针
                sum += nums[fast];
                fast++;
            }
            while (sum >= s) {
                //滑动窗口子数组和大于等于目标值时，向右移动慢指针，并求解最小长度
                result = Math.min(result, fast - slow);
                sum -= nums[slow];
                slow++;
            }
        }
        //对特殊情况进行判断，如果目标值s大于整个数组和就直接返回0
        return result == nums.length + 1 ? 0 : result;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
