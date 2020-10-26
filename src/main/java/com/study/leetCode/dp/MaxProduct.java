package main.java.com.study.leetCode.dp;

/**
 * @author： whb
 * @description： LeetCode-152-乘积最大子数组
 * @date： 2020-10-26 10:14
 * 难度：中等
 * 标签：数组、动态规划
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaxProduct {
    /**
     * 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
     * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
     * 当负数出现时则imax与imin进行交换再进行下一步计算
     * 时间复杂度：O(n)O
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = max;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);
            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }
}
