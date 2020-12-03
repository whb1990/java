package main.java.com.study.leetCode.mathematics;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-338-比特位计数
 * @date： 2020-12-03 10:21
 * 难度：中等
 * 标签：位运算、动态规划
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 *
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 */
public class CountBits {
    /**
     * 方法一：
     * i & (i - 1)可以去掉i最右边的一个1（如果有），因此 i & (i - 1）是比 i 小的，
     * 而且i & (i - 1)的1的个数已经在前面算过了，所以i的1的个数就是 i & (i - 1)的1的个数加上1
     *
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        //注意要从1开始，0不满足
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    /**
     * 方法二：
     * i >> 1会把最低位去掉，因此i >> 1 也是比i小的，同样也是在前面的数组里算过。
     * 当 i 的最低位是0，则 i 中1的个数和i >> 1中1的个数相同；
     * 当i的最低位是1，i 中1的个数是 i >> 1中1的个数再加1
     *
     * @param num
     * @return
     */
    public static int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            //注意i&1需要加括号
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    /**
     * 方法三：
     * 对于所有的数字，只有两类：
     * 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
     * 举例：
     *          0 = 0       1 = 1
     *          2 = 10      3 = 11
     *
     * 偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
     *  举例：
     *           2 = 10       4 = 100       8 = 1000
     *           3 = 11       6 = 110       12 = 1100
     *
     * 另外，0 的 1 个数为 0，于是就可以根据奇偶性开始遍历计算了。
     * @param num
     * @return
     */
    public static int[] countBits3(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 1) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = res[i >> 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(5)));
        System.out.println(Arrays.toString(countBits2(2)));
        System.out.println(Arrays.toString(countBits2(5)));
        System.out.println(Arrays.toString(countBits3(2)));
        System.out.println(Arrays.toString(countBits3(5)));
    }
}
