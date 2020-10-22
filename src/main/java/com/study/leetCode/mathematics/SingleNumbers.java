package main.java.com.study.leetCode.mathematics;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-剑指Offer56-Ⅰ.数组中数字出现的次数
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
public class SingleNumbers {
    /**
     * 分组异或
     * 异或运算的几个性质
     * 相同的数异或为0，不同的异或为1。0和任何数异或等于这个数本身。
     * 交换律
     * 结合律（即(a^b)^c == a^(b^c)）
     * 对于任何数x，都有x^x=0，x^0=x
     * 自反性 A XOR B XOR B = A xor 0 = A ---> A XOR B = C 则 C XOR B = A
     * <p>
     * 所以，数组里面所有数异或 = 目标两个数异或 。 由于这两个数不同，所以异或结果必然不为0。
     * <p>
     * 假设数组异或的二进制结果为10010，那么说明这两个数从右向左数第2位是不同的
     * <p>
     * 那么可以根据数组里面所有数的第二位为0或者1将数组划分为2个。
     * <p>
     * 这样做可以将目标数必然分散在不同的数组中，而且相同的数必然落在同一个数组中。
     * <p>
     * 这两个数组里面的数各自进行异或，得到的结果就是答案
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
