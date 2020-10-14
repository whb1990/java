package main.java.com.study.leetCode.mathematics;

/**
 * @author： whb
 * @description： LeetCode-461-汉明距离
 * @date： 2020-10-14 18:21
 * 难度：简单
 * 标签：数学、位运算
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * 示例:
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class HammingDistance {
    /**
     * 布赖恩·克尼根算法
     * 该算法使用特定比特位和算术运算移除等于 1 的最右比特位。
     * 当我们在 number 和 number-1 上做 AND 位运算时，原数字 number 的最右边等于 1 的比特会被移除。
     * 基于以上思路，通过 2 次迭代就可以知道 10001000 中 1 的位数，而不需要 8 次。
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int count = 0;
        int z = x ^ y;
        while (z != 0) {
            count++;
            z &= (z - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
