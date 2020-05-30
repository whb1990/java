package main.java.com.study.leetCode.recursion;

/**
 * @author: whb
 * @date: 2020/5/30 14:54
 * @description: LeetCode-50-Pow(x,n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 */
public class MyPow {

    /**
     * 递归快速幂
     * pow(x,n)就是求x的n次方。x的N次方可以看做：x^n = x^(n/2)*x^(n/2)*x^(n%2)。所以利用递归求解，当n==1的时候，x^n=x。
     * <p>
     * 当然n是可以小于0的，2^(-3) = 1/(2^3)。按照上面那个规律就可以解决了。
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / fastPow(x, -n);
        }
        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double result = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return result * result;
        }
        return result * result * x;
    }

    /**
     * 迭代法
     */
    public double myPow2(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -n;
        }
        double ans = 1;
        double curr = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                ans = ans * curr;
            }
            curr = curr * curr;
        }
        return ans;
    }

    /**
     * 暴力求解法
     * 只需模拟将 x 相乘 n 次的过程。
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow3(double x, int n) {
        if (x == 0.0) {
            return 0.0;
        }
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double result = 1.0;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

}
