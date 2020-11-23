package main.java.com.study.leetCode.prefixes;

/**
 * @author： whb
 * @description： LeetCode-1664-生成平衡数组的方案数
 * @date： 2020-11-23 10:16
 * 难度：中等
 * 标签：贪心算法、动态规划
 * 给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
 *
 * 比方说，如果 nums = [6,1,7,4,1] ，那么：
 *
 * 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
 * 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
 * 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
 * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
 *
 * 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
 *
 * 示例 1：
 * 输入：nums = [2,1,6,4]
 * 输出：1
 * 解释：
 * 删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
 * 删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
 * 删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
 * 删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
 * 只有一种让剩余数组成为平衡数组的方案。
 *
 * 示例 2：
 * 输入：nums = [1,1,1]
 * 输出：3
 * 解释：你可以删除任意元素，剩余数组都是平衡数组。
 *
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：0
 * 解释：不管删除哪个元素，剩下数组都不是平衡数组。
 *
 *
 * 提示：
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class WaysToMakeFair {
    /**
     * 奇偶前缀和+两次遍历
     * 从前往后尝试去除各个元素，在去除索引为i的元素之后，i之前奇偶索引位置的元素和不变，i之后由于每个位置的索引减一，所以奇偶和互相交换。
     * 只要维护两个前缀和数组分别表示当前位置及之前的奇数索引元素的和，以及偶数索引元素的和即可。
     * 若两数组分别为odd[i]和even[i],去除nums[i]之后，i之前的奇偶和分别为odd[i - 1]和even[i - 1]，之后的奇偶和分别为even[len - 1] - even[i]和odd[len - 1] - odd[i]，
     * 判断(even[i - 1] + odd[len - 1] - odd[i] == odd[i - 1] + even[len - 1] - even[i] 即可
     *
     * @param nums
     * @return
     */
    public static int waysToMakeFair(int[] nums) {
        int res = 0, odd = 0, even = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                odd += nums[i];
            } else {
                even += nums[i];
            }
        }
        if (odd == even) {
            res++;
        }
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                odd += nums[i - 1] - nums[i];
            } else {
                even += nums[i - 1] - nums[i];
            }
            if (odd == even) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(waysToMakeFair(new int[]{2, 1, 6, 4}));
        System.out.println(waysToMakeFair(new int[]{1, 1, 1}));
        System.out.println(waysToMakeFair(new int[]{1, 2, 3}));
    }
}
