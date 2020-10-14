package main.java.com.study.leetCode.mathematics;

/**
 * @author： whb
 * @description： LeetCode-326-3的幂
 * @date： 2020-10-14 17:38
 * 难度：简单
 * 标签：数学
 */
public class IsPowerOfThree {
    /**
     * 循环迭代
     * 找出数字 n 是否是数字 b 的幂的一个简单方法是，n%3 只要余数为 0，就一直将 n 除以 b。
     * n = bxn = b×b×…×b
     * ​
     * 因此，应该可以将 n 除以 b x 次，每次都有 0 的余数，最终结果是 1。
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThree(int n) {
        if (n < 3) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(45));
    }
}
