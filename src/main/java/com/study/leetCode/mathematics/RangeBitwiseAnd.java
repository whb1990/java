package main.java.com.study.leetCode.mathematics;

/**
 * @author: whb
 * @date: 2020/8/26 10:06
 * @description: LeetCode-201-数字范围按位与
 * 难度：中等
 * 标签：位运算
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1: 
 * 输入: [5,7]
 * 输出: 4
 *
 * 示例 2:
 * 输入: [0,1]
 * 输出: 0
 */
public class RangeBitwiseAnd {
    /**
     * Brian Kernighan 算法
     * Brian Kernighan 算法的关键在于我们每次对 number 和 number−1 之间进行按位与运算后，number 中最右边的 1 会被抹去变成 0。
     * 比如十进制的 10，二进制形式是 1010，然后我们只需要把它和 9 进行按位与操作，也就是 10 & 9 = (1010) & (1001) = 1000，也就是把 1010 最右边的 1 置为 0。
     *
     * 规律就是对于任意一个数 n，然后 n & (n-1) 的结果就是把 n 的最右边的 1 置为 0 。
     *
     * 也比较好理解，当我们对一个数减 1 的话，比如原来的数是 ...1010000，然后减一就会向前借位，直到遇到最右边的第一个 1，变成 ...1001111，然后我们把它和原数按位与，就会把从原数最右边 1 开始的位置全部置零了 ...10000000。
     * 用 n 这个变量去保存最终的结果，只需要考虑 n 的低位的 1 是否需要置为 0。
     *
     *
     * m X X X X X X X X
     *   ...
     * n X X X X 1 0 0 0
     *
     * 此时 m < n，上边的解法中然后我们会依次进行右移，我们考虑把 n 低位的 0 移光直到 1 移动到最低位
     *
     * m2 X X X X X
     *   ...
     * n2 X X X X 1
     *
     * 此时如果 m2 < n2，那么我们就可以确定最低位相与的结果一定是 0
     *
     * 回到开头 , n 的低位都是 0, 所以从 m < n 一定可以推出 m2 < n2, 所以最终结果的当前位一定是 0
     *
     * 因此，如果 m < n ，我们只需要把 n ，也就是 X X X X 1 0 0 0 的最右边的 1 置 0, 然后继续考虑。
     * 时间复杂度：O(logn)。和位移方法类似，算法的时间复杂度取决于 m 和 n 二进制展开的位数。尽管和位移方法具有相同的渐近复杂度，但 Brian Kernighan 的算法需要的迭代次数会更少，因为它跳过了两个数字之间的所有零位。
     * 空间复杂度：O(1)。只需要常数空间存放若干变量。
     * 结语
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return n;
    }
    public static void main(String[] args){
        System.out.println(rangeBitwiseAnd(5, 7));
        System.out.println(rangeBitwiseAnd(0, 1));
    }
}
