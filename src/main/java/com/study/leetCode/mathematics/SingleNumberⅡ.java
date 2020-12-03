package main.java.com.study.leetCode.mathematics;

/**
 * @author： whb
 * @description： LeetCode-137-只出现一次的数字Ⅱ
 * @date： 2020-12-03 11:21
 * 难度：中等
 * 标签：位运算
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 */
public class SingleNumberⅡ {
    /**
     * 解释下：假设有一个数为x,那么则有如下规律：
     * 0 ^ x = x,
     * x ^ x = 0；
     * x & ~x = 0,
     * x & ~0 =x;
     * <p>
     * 一开始a = 0, b = 0;
     * x第一次出现后，a = (a ^ x) & ~b的结果为 a = x, b = (b ^ x) & ~a的结果为此时因为a = x了，所以b = 0。
     * x第二次出现：a = (a ^ x) & ~b, a = (x ^ x) & ~0, a = 0; b = (b ^ x) & ~a 化简， b = (0 ^ x) & ~0 ,b = x;
     * x第三次出现：a = (a ^ x) & ~b， a = (0 ^ x) & ~x ,a = 0; b = (b ^ x) & ~a 化简， b = (x ^ x) & ~0 , b = 0;所以出现三次同一个数，a和b最终都变回了0.
     * 只出现一次的数，按照上面x第一次出现的规律可知a = x, b = 0;因此最后返回a.
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            a = ~b & (a ^ num);
            b = ~a & (b ^ num);
        }
        return a;
    }

    /**
     * 将每个数想象成32位的二进制，对于每一位的二进制的1和0累加起来必然是3N或者3N+1， 为3N代表目标值在这一位没贡献，3N+1代表目标值在这一位有贡献(=1)，
     * 然后将所有有贡献的位|起来就是结果。这样做的好处是如果题目改成K个一样，只需要把代码改成count % k，很通用。
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i, count = 0;
            for (int num : nums) {
                if ((num & mask) != 0) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                res |= mask;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
        System.out.println(singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
