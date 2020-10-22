package main.java.com.study.leetCode.mathematics;

/**
 * @author： whb
 * @description： 剑指Offer65-不用加减乘除做加法
 * @date： 2020-10-22 9:39
 * 难度：简单
 * 标签：位运算、数学
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 * <p>
 * 提示：
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 */
public class Add {
    /**
     * 设两数字的二进制形式a,b ，其求和s=a+b ，a(i) 代表 a 的二进制第 i 位，则分为以下四种情况：
     *
     * a(i)	b(i) 无进位和n(i) 进位 c(i+1)
     *  0	 0	   0	         0
     *  0	 1	   1	         0
     *  1	 0	   1	         0
     *  1	 1	   0	         1
     * 观察发现，无进位和 与 异或运算 规律相同，进位 和 与运算 规律相同（并需左移一位）。因此，无进位和 n 与进位 c 的计算公式如下；
     * n=a⊕b        非进位和：异或运算
     * c=a&b<<1     进位：与运算+左移一位
     *（和 s）==（非进位和 n ）+（进位 c ）。即可将 s = a + b转化为：
     * s=a+b⇒s=n+c
     *
     * 循环求 n 和 c ，直至进位 c = 0；此时 s = n，返回 n 即可。
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 1));
    }
}
