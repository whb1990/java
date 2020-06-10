package main.java.com.study.leetCode.binarySearch;

/**
 * @author: whb
 * @date: 2020/6/10 14:29
 * @description: LeetCode-162-寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 * <p>
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * <p>
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * <p>
 * 示例 2:
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 */
public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        // 因为nums[-1]为负无穷，此时nums[0]满足
        if (nums[0] > nums[1]) {
            return 0;
        }
        // 因为nums[nums.length]为负无穷，此时nums[length-1]满足
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        //因为已经判断了nums[0]和nums[length-1]是否满足，所以缩小范围防止溢出
        return find(nums, 1, nums.length - 2);
    }

    private static int find(int[] nums, int left, int right) {
        int middle = left + (right - left) / 2;
        if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]) {
            return middle;
        }
        if (nums[middle] < nums[middle - 1]) {
            return find(nums, left, middle - 1);
        }
        return find(nums, middle + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
    }
}
