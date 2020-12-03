package main.java.com.study.leetCode.mathematics;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-260-只出现一次的数字Ⅲ
 * @date： 2020-10-22 14:55
 * 难度：中等
 * 标签：位运算、数学
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * <p>
 * 限制：
 * 2 <= nums.length <= 10000
 */
public class SingleNumberⅢ {
    /**
     * 第一步：
     * 把所有的元素进行异或操作，最终得到一个异或值。因为是不同的两个数字，所以这个值必定不为 0；
     * 第二步：
     * 取异或值最后一个二进制位为 1 的数字作为 mask，如果是 1 则表示两个数字在这一位上不同。
     * 第三步：
     * 通过与这个 mask 进行与操作，如果为 0 的分为一个数组，为 1 的分为另一个数组。
     * 这样就把问题降低成了：“有一个数组每个数字都出现两次，有一个数字只出现了一次，求出该数字”。对这两个子问题分别进行全异或就可以得到两个解。也就是最终的数组了。
     *
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {
        // 假设结果数为A B
        // x用于记录 A B 的异或结果
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        // x & (-x)本身的作用是得到最低位的1，
        int flag = x & (-x);
        // 而我们所需要的做到的是：利用这个1来进行分组，也就是做到将A和B区分开
        // 前面已经知道，x是我们需要的结果数A和B相异或的结果，也就是说，x的二进制串上的任何一个1，都能成为区分A和B的条件
        // 因此我们只需要得到x上的任意一个1，就可以做到将A和B区分开来
        // res用于记录A或B其中一者
        int res = 0;
        // 分组操作
        for (int num : nums) {
            // 根据二进制位上的那个“1”进行分组
            // 需要注意的是，分组的结果必然是相同的数在相同的组，且还有一个结果数
            // 因此每组的数再与res=0一路异或下去，最终会得到那个结果数A或B
            // 且由于异或运算具有自反性，因此只需得到其中一个数即可
            if ((flag & num) == 0) {
                res ^= num;
            }
        }
        // 利用先前的x进行异或运算得到另一个，即利用自反性
        return new int[]{res, x ^ res};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumbers(new int[]{4, 1, 4, 6})));
        System.out.println(Arrays.toString(singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3})));
    }
}
