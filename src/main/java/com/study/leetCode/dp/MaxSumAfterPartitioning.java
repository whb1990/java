package main.java.com.study.leetCode.dp;

/**
 * @author： whb
 * @description： LeetCode-1043-分隔数组以得到最大和
 * @date： 2020-12-05 10:57
 * 难度：中等
 * 标签：动态规划
 * 给你一个整数数组 arr，请你将该数组分隔为长度最多为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
 *
 * 返回将数组分隔变换后能够得到的元素最大和。
 *
 *
 *
 * 注意，原数组和分隔后的数组对应顺序应当一致，也就是说，你只能选择分隔数组的位置而不能调整数组中的顺序。
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,15,7,9,2,5,10], k = 3
 * 输出：84
 * 解释：
 * 因为 k=3 可以分隔成 [1,15,7] [9] [2,5,10]，结果为 [15,15,15,9,10,10,10]，和为 84，是该数组所有分隔变换后元素总和最大的。
 * 若是分隔成 [1] [15,7,9] [2,5,10]，结果就是 [1, 15, 15, 15, 10, 10, 10] 但这种分隔方式的元素总和（76）小于上一种。
 *
 * 示例 2：
 *
 * 输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * 输出：83
 *
 * 示例 3：
 *
 * 输入：arr = [1], k = 1
 * 输出：1
 *
 *
 * 提示：
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 109
 * 1 <= k <= arr.length
 */
public class MaxSumAfterPartitioning {
    /**
     * 对于数组求 最大  最小问题 一般为 动态规划问题
     *
     * 建立一维数组dp dp[i] 表示：从 0 到 位置 i 子数组的最大和
     *
     *     对于每一个位置 都可能有 k 种情况：
     *          ①：只使用它自己位置的数字
     *          ②：让他保持和前面 1 个数字相同
     *          ........
     *          ⑩：让他保持和前面 k - 1 个数字相同
     *     转移方程：
     *          ①：domainMax = Math.max(domainMax, arr[i - j + 1]);
     *             作用：求它和前面 j - 1 个数字的最大值 为保持相同的数字
     *          ②：dp[i] = Math.max(dp[i], ((i - j < 0)? 0 : dp[i - j])  + j * domainMax);
     *             作用：求位置 i 的时候 k 种情况 的最大值
     *     边界条件：
     *          ①：i - j + 1 >= 0
     *             作用：保证它的前面有 j - 1 个元素
     *          ②：i - j < 0？
     *             作用：判断 当 前面恰有 j - 1 个元素 且 第 i 个位置 保持和前面 j - 1 个数字相同
     * @param arr
     * @param k
     * @return
     */
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int domainMax = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                domainMax = Math.max(domainMax, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], (i - j < 0 ? 0 : dp[i - j]) + j * domainMax);
            }
        }
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
        System.out.println(maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));
    }
}
