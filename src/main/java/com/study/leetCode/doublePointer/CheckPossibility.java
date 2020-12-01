package main.java.com.study.leetCode.doublePointer;

/**
 * @author： whb
 * @description： LeetCode-665-非递减数列
 * @date： 2020-12-01 9:10
 * 难度：简单
 * 标签：数组、双指针
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * 示例 1:
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 *
 * 示例 2:
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 * 说明：
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 */
public class CheckPossibility {
    /**
     * 双指针解法
     * 根据题意，破坏非递减数组序列的结构是‘N’字型结构。具体解法可以设置双指针，分别从数组两端往中间搜索，当碰到失序地方的时候停下来。
     * 若至多改变一个元素能将原数组调整有序，当只有一处失序存在时必定有high = low + 1,当数组完全符合非递减时high = low,因此high-low<=1是命题的必要条件。
     * 另一方面如图所示，当失序的时候有两种调整方案：
     * 1.改变位置low,使得nums[low-1]≤nums[low]≤nums[low+1];
     * 2.改变位置high,使得nums[high-1]≤nums[high]≤nums[high+1];
     * 采用方案1前提条件为nums[low+1]>=nums[low-1],采用方案2前提条件为nums[high+1]>=nums[high-1]。
     * 再考虑两种端点情况，即在最开始和最结尾失序，low=0或者high=len-1时，一定可以调整。
     *
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length <= 2) {
            return true;
        }
        int low = 0, high = nums.length - 1;
        while (low < high && nums[high - 1] <= nums[high]) {
            high--;
        }
        while (low < high && nums[low] <= nums[low + 1]) {
            low++;
        }
        if (high - low > 1) {
            return false;
        }
        //除了边界，其他递增
        if (low == 0 || high == nums.length - 1
                //除了nums[low]其他都递增
                || nums[low - 1] <= nums[low + 1]
                //除了nums[high]其他都递增
                || nums[high - 1] <= nums[high + 1]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4, 2, 3}));
        System.out.println(checkPossibility(new int[]{4, 2, 1}));
        System.out.println(checkPossibility(new int[]{5, 7, 1, 8}));
    }
}
