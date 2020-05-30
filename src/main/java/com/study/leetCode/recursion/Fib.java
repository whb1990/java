package main.java.com.study.leetCode.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: whb
 * @date: 2020/5/30 11:43
 * @description: LeetCode-斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 */
public class Fib {
    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(4));
    }

    //缓存计算的结果，防止重复计算
    Map<Integer, Integer> cacheMap = new HashMap<>();

    /**
     * 计算斐波那契数
     *
     * @param N
     * @return
     */
    public int fib(int N) {
        if (cacheMap.containsKey(N)) {
            return cacheMap.get(N);
        }
        int result;
        if (N < 2) {
            result = N;
        } else {
            result = fib(N - 1) + fib(N - 2);
        }
        //缓存计算结果
        cacheMap.put(N, result);
        return result;
    }
}
