package main.java.com.study.leetCode.mathematics;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-204-计数质数
 * @date： 2020-10-14 17:27
 * 难度：简单
 * 标签：数学
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * <p>
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 *  
 * <p>
 * 提示：
 * 0 <= n <= 5 * 106
 */
public class CountPrimes {
    /**
     * 厄拉多塞筛法(Sieve of Eratosthenes)
     * 比如说求20以内质数的个数,首先0,1不是质数.2是第一个质数,然后把20以内所有2的倍数划去.2后面紧跟的数即为下一个质数3,然后把3所有的倍数划去.3后面紧跟的数即为下一个质数5,再把5所有的倍数划去.以此类推.
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        // 将数组都初始化为 true
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // i 的倍数不可能是素数了
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("10以内有->" + countPrimes(10) + "<-个质数");
        System.out.println("0以内有->" + countPrimes(0) + "<-个质数");
        System.out.println("1以内有->" + countPrimes(1) + "<-个质数");
    }
}
