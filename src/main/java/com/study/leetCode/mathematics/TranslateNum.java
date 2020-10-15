package main.java.com.study.leetCode.mathematics;

/**
 * @author： whb
 * @description： LeetCode-剑指Offer46-把数字翻译成字符串
 * @date： 2020-10-15 14:37
 * 难度：中等
 * 标签：数学、动态规划
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 * 提示：
 * 0 <= num < 231
 */
public class TranslateNum {
    /**
     * 递归
     *
     * @param num
     * @return
     */
    public static int translateNum(int num) {
        if (num <= 9) {
            return 1;
        }
        //获取输入数字的余数，然后递归的计算翻译方法
        int remainder = num % 100;
        //如果小于等于9或者大于等于26的时候，余数不能按照2位数字组合，
        // 比如56，只能拆分为5和6；反例25，可以拆分为2和5，也可以作为25一个整体进行翻译。
        if (remainder <= 9 || remainder >= 26) {
            return translateNum(num / 10);
        }
        // remainder=[10, 25]时，既可以当做一个字母，也可以当做两个字母
        return translateNum(num / 10) + translateNum(num / 100);
    }

    /**
     * 动态规划
     *
     * @param num
     * @return
     */
    public static int translateNum2(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
        System.out.println(translateNum2(12258));
    }
}
