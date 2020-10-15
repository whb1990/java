package main.java.com.study.leetCode.mathematics;

/**
 * @author： whb
 * @description： LeetCode-268-丢失的数字
 * @date： 2020-10-15 15:31
 * 难度：简单
 * 标签：数学、位运算、数组
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * 示例 1：
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 3：
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 4：
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 */
public class MissingNumber {
    /**
     * 异或XOR解法
     * 参照：LeetCode-540-有序数组中的单一元素 的异或解法
     * <p>
     * 由于异或运算（XOR）满足结合律，并且对一个数进行两次完全相同的异或运算会得到原来的数，因此可以通过异或运算找到缺失的数字。
     * <p>
     * 数组中有 n 个数，并且缺失的数在 [0..n] 中。因此可以先得到 [0..n] 的异或值，再将结果对数组中的每一个数进行一次异或运算。
     * 未缺失的数在 [0..n] 和数组中各出现一次，因此异或后得到 0。而缺失的数字只在 [0..n] 中出现了一次，在数组中没有出现，因此最终的异或结果即为这个缺失的数字。
     * 举个例子：
     * 0 ^ 4 = 4
     * 4 ^ 4 = 0
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
        System.out.println(missingNumber(new int[]{0, 1}));
        System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(missingNumber(new int[]{0}));
    }
}
