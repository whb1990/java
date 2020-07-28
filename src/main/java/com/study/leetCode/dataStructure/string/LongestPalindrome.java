package main.java.com.study.leetCode.dataStructure.string;

/**
 * @author: whb
 * @date: 2020/6/3 18:55
 * @description: LeetCode-5-最长回文子串
 * 难度：中等
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {

    /**
     * 初始状态：
     * dp[i][i] = 1;//单个字符是回文串
     * dp[i][i+1] = 1 if s[i] = s[i+1];//连续两个相同的字符是回文串
     * 给出P(i,j)的定义如下：
     * P(i,j) = true, if s[i]....s[j]是回文串
     * 因此P(i,j) = (P(i + 1, j -1) and s[i] == s[j])
     * 基本示例如下：
     * P(i,i) = true
     * P(i, i + 1) = (s[i] == s[i+1]);
     *
     * @param str
     * @return
     */
    public static String longestPalindrome(String str) {
        int len = str.length();
        if (len == 0 || len == 1) {
            return str;
        }
        //定义二维数组，dp值为1表示为true，为0表示false
        int[][] dp = new int[len][len];
        //回文串的起始位置
        int start = 0;
        //回文串最大长度
        int maxLen = 1;
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i < len - 1 && str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                start = 1;
                maxLen = 2;
            }
        }
        //sl表示检索子串的长度，等于3表示先检索长度为3的的字串
        for (int sl = 3; sl < len; sl++) {
            for (int i = 0; i + sl - 1 < len; i++) {
                //终止字符位置
                int j = sl + i - 1;
                //状态转移
                if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    start = i;
                    maxLen = sl;
                }
            }
        }
        //获取最长回文子串
        return str.substring(start, start + maxLen);
    }

    /**
     * 先建立一个二维数组dp,令dp[i][j]表示s[i...j] = 1是回文字符串,用其等于0则表示不是回文子串
     * <p>
     * 如果s.charAt(i)==s.charAt(j)并且dp[i+1][j-1]里面是true,则 dp[i][j]也为true,之后就可以开始做了
     * <p>
     * 先将数组初始化,即相邻两个相同的字母组成的子串和单个的字母都是回文串
     * <p>
     * 所以dp[i][i]为true,dp[i][i+1]也为true
     * <p>
     * 之后再从最长回文子串为3开始筛选,如果长度比已知的最长回文子串长,那么就更新最长回文子串
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s.length() < 1) {
            return s;
        }
        String longest = s.charAt(0) + "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int j = len - 1; j >= 0; j--) {
            //j在前，i在后
            for (int i = j; i < len; i++) {
                dp[j][i] = s.charAt(i) == s.charAt(j) && ((i - j < 3) || dp[j + 1][i - 1]);
                if (dp[j][i] && i - j + 1 > longest.length()) {
                    longest = s.substring(j, i + 1);
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ababa"));
    }
}
