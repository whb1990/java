package main.java.com.study.leetCode.dp;

/**
 * @author: whb
 * @date: 2020/8/19 10:12
 * @description: LeetCode-5-最长回文子串
 * 难度：中等
 * 标签：字符串、动态规划
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {
    /**
     * 动态规划解法
     * 1、状态：dp[i][j] 表示字符串s在[i,j]区间的子串是否是一个回文串。
     * 2、状态转移方程：当 s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1]) 时，dp[i][j]=true，否则为false
     * 3、这个状态转移方程是什么意思呢？
     * 3.1、当只有一个字符时，比如a自然是一个回文串。
     * 3.2、当有两个字符时，如果是相等的，比如aa，也是一个回文串。
     * 3，3、当有三个及以上字符时，比如ababa这个字符记作串1，把两边的a去掉，也就是bab记作串2，可以看出只要串2是一个回文串，那么左右各多了一个a的串1必定也是回文串。
     * 所以当s[i]==s[j]时，自然要看dp[i+1][j-1]是不是一个回文串。
     * 时间复杂度为O(N^2)，空间复杂度为O(N^2)。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String result = "";
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    String tmp = s.substring(i, j + 1);
                    result = tmp.length() > result.length() ? tmp : result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
}

