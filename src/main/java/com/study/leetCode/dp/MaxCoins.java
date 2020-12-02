package main.java.com.study.leetCode.dp;

/**
 * @author： whb
 * @description： LeetCode-312-戳气球
 * @date： 2020-12-02 17:49
 * 难度：困难
 * 标签：区间动态规划
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 *
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 *
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class MaxCoins {
    /**
     * 1、状态表示：
     * dp[i][j]表示第i至第j个元素这个区间能获得的最大硬币数。
     * 2、状态计算：
     * 2.1、扩展数组，加上题中的nums[-1] = nums[n] = 1，这样计算动态规划新数组的[1,n]
     * 2.2、k表示在i,j这个区间内最后戳破的气球，状态转移方程：
     * dp[i][j]=max(dp[i][j],dp[i][k]+dp[k][j]+nums[i]*nums[k]*nums[j]);
     * 2.3、dp[i][k] + dp[k][j]表示[i,k]与[k, j]被戳破所获得的最大coins数，nums[i] * nums[k] * nums[j]表示最后戳破第k个气球所获得coins数目。
     * 2.4、k 遍历(i ,i + len - 1]) 保存最大值。
     * 3、初始化：
     * 全部初始化为0
     *
     * @param nums
     * @return
     */
    public static int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 创建一个辅助数组，并在首尾各添加1，方便处理边界情况
        int[] arr = new int[nums.length + 2];
        System.arraycopy(nums, 0, arr, 1, nums.length);
        arr[0] = arr[arr.length - 1] = 1;
        int[][] dp = new int[arr.length][arr.length];
        //区间dp模板
        // len表示开区间长度
        for (int len = 2; len <= arr.length; len++) {
            // i表示开区间左端点
            for (int i = 0; i <= arr.length - len; i++) {
                // j表示开区间右端点
                int j = i + len - 1;
                //k表示开区间内的索引，是(i,j)区间内最后一个被戳的气球
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                }
            }
        }
        return dp[0][arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));

    }
}
