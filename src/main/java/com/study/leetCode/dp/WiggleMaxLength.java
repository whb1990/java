package main.java.com.study.leetCode.dp;

/**
 * @author： whb
 * @description： LeetCode-376-摆动序列
 * @date： 2020-11-27 9:15
 * 难度：中等
 * 标签：动态规划、贪心算法
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 *
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 *
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * 示例 1:
 *
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 *
 * 示例 2:
 *
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 *
 * 示例 3:
 *
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 * 进阶:
 * 你能否用 O(n) 时间复杂度完成此题?
 */
public class WiggleMaxLength {
    /**
     * 动态规划
     * dp[i][0]表示从nums[0]到nums[i]的最长摆动序列长度，且nums[i] < nums[i - 1]，
     * dp[i][1]表示从nums[0]到nums[i]的最长摆动序列长度，且nums[i] > nums[i - 1 ]。
     * 数组中的任何元素都对应下面三种可能状态中的一种：
     * 1）上升的位置，意味着 nums[i] > nums[i - 1]nums[i]>nums[i−1]；
     * 2）下降的位置，意味着 nums[i] < nums[i - 1]nums[i]<nums[i−1]；
     * 3）相同的位置，意味着 nums[i] == nums[i - 1]nums[i]==nums[i−1]；
     *
     * 更新的过程如下：
     * 1、如果 nums[i] > nums[i-1] ，意味着这里在摆动上升，前一个数字肯定处于下降的位置。所以 dp[i][1] = dp[i-1][0] + 1 ， dp[i][0] 与 dp[i-1][0] 保持相同。
     *
     * 2、如果 nums[i] < nums[i-1]，意味着这里在摆动下降，前一个数字肯定处于下降的位置。所以 dp[i][0] = dp[i-1][1] + 1， dp[i][1] 与 dp[i-1][1] 保持不变。
     *
     * 3、如果 nums[i] == nums[i-1]，意味着这个元素不会改变任何东西因为它没有摆动。所以 dp[i][0] 与 dp[i][1] 与 dp[i-1][0] 和 dp[i-1][1] 都分别保持不变。
     *
     * 最后，可以将 dp[length-1][0] 和 dp[length-1][1] 中的较大值作为问题的答案，其中 length是给定数组中的元素数目。
     *
     * @param nums
     * @return
     */
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][1];
            } else if (nums[i] > nums[i - 1]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    /**
     * 动态规划---空间优化
     *
     * @param nums
     * @return
     */
    public static int wiggleMaxLength2(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            } else if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
        }
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));

        System.out.println(wiggleMaxLength2(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(wiggleMaxLength2(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(wiggleMaxLength2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
