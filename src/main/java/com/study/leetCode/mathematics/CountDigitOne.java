package main.java.com.study.leetCode.mathematics;

/**
 * @author： whb
 * @description： LeetCode-233-数字1的个数
 * @date： 2020-10-16 14:59
 * 难度：困难
 * 标签：数学
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * 
 * 示例:
 * 输入: 13
 * 输出: 6
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 */
public class CountDigitOne {
    /**
     * 总体思想就是分类，先求所有数中个位是 1 的个数，再求十位是 1 的个数，再求百位是 1 的个数...
     * 
     * 假设 n = xyzdabc，此时我们求千位是 1 的个数，也就是 d 所在的位置。
     * 
     * 那么此时有三种情况，
     * 
     * d == 0，那么千位上 1 的个数就是 xyz * 1000
     * d == 1，那么千位上 1 的个数就是 xyz * 1000 + abc + 1
     * d > 1，那么千位上 1 的个数就是 xyz * 1000 + 1000
     * 为什么呢？
     * 
     * 当我们考虑千位是 1 的时候，我们将千位定为 1，也就是 xyz1abc。
     * 
     * 对于 xyz 的话，可以取 0,1,2...(xyz-1)，也就是 xyz 种可能。
     * 
     * 当 xyz 固定为上边其中的一个数的时候，abc 可以取 0,1,2...999，也就是 1000 种可能。
     * 
     * 这样的话，总共就是 xyz*1000 种可能。
     * 
     * 注意到，我们前三位只取到了 xyz-1，那么如果取 xyz 呢？
     * 
     * 此时就出现了上边的三种情况，取决于 d 的值。
     * 
     * d == 1 的时候，千位刚好是 1，此时 abc 可以取的值就是 0 到 abc ，所以多加了 abc + 1。
     * 
     * d > 1 的时候，d 如果取 1，那么 abc 就可以取 0 到 999，此时就多加了 1000。
     *
     * @param n
     * @return
     */
    public static int countDigitOne(int n) {
        int num = n, i = 1, res = 0;
        while (num > 0) {
            // 不包含1 -9
            if (num % 10 == 0) {
                // 修正值是 0
                res += (num / 10) * i;
            }
            // 包含 1 - 9的一部分
            if (num % 10 == 1) {
                // 修正值是(n % i) + 1
                res += (num / 10) * i + (n % i) + 1;
            }
            // 包含1 - 9
            if (num % 10 > 1) {
                // 修正值是 i
                res += (num / 10) * i + i;
            }
            // 比如109/10 = 10， 可以按10位的处理，因为i增量了10倍
            num /= 10;
            // 每次1的个数是增加10倍
            i *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(13));
    }
}
