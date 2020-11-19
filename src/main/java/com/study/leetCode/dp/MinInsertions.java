package main.java.com.study.leetCode.dp;

/**
 * @author： whb
 * @description： LeetCode-1312-让字符串成为回文串的最少插入次数
 * @date： 2020-11-19 8:38
 * 难度：困难
 * 标签：动态规划
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 *
 * 请你返回让 s 成为回文串的 最少操作次数 。
 *
 * 「回文串」是正读和反读都相同的字符串。
 *
 * 示例 1：
 * 输入：s = "zzazz"
 * 输出：0
 * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
 *
 * 示例 2：
 * 输入：s = "mbadm"
 * 输出：2
 * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
 *
 * 示例 3：
 * 输入：s = "leetcode"
 * 输出：5
 * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
 *
 * 示例 4：
 * 输入：s = "g"
 * 输出：0
 *
 * 示例 5：
 * 输入：s = "no"
 * 输出：1
 *
 * 提示：
 * 1 <= s.length <= 500
 * s 中所有字符都是小写字母。
 */
public class MinInsertions {
    /**
     * 1、dp数组定义
     * dp[i][j] 表示字符串s[i...j]，要变成回文串时最少需要dp[i][j]次插入
     *
     * 根据dp数组可知所求结果为dp[0][n-1]（n为s的长度）
     *
     * 2、选择 和 状态
     * 选择: 字符s[i]和s[j]
     * 状态: dp[i][j]最少插入次数的改变
     * 状态转移
     * 如果s[i] == s[j]，此时结果s[i, j]和s[i+1..j-1]回文串的插入次数相等，所以dp[i][j]=dp[i+1][j-1]
     *
     * 如果s[i] != s[j]，此时结果为回文串s[i..j-1]或者s[i+1..j]，取两者中的小者后加上1即可，
     * (
     * 把s[i..j-1]变回文串，可以在s[i..j-1]左边插入一个字符s[j]可以将s[i..j]变成回文串
     * 把s[i+1..j]变回文串，可以在s[i+1..j]右边插入一个字符s[i]可以将s[i..j]变成回文串
     * )
     *
     * 3、 base case
     * 当i == j时，dp[i][j] = 0
     *
     * 因为当i == j时，s[i..j]就只是一个字符，一个字符本身就是回文串，不需要进行任何插入操作，所以为0
     * @param s
     * @return
     */
    public static int minInsertions(String s) {
        if (s.isEmpty() || s.length() <= 1) {
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    /**
     * 状态压缩
     *
     * @param s
     * @return
     */
    public static int minInsertions2(String s) {
        if (s.isEmpty() || s.length() <= 1) {
            return 0;
        }
        int tmp = 0;
        int[] dp = new int[s.length()];
        for (int i = s.length() - 2; i >= 0; i--) {
            int pre = 0;
            for (int j = i + 1; j < s.length(); j++) {
                tmp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = pre;
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + 1;
                }
                pre = tmp;
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(minInsertions("zzazz"));
        System.out.println(minInsertions("mbadm"));
        System.out.println(minInsertions("leetcode"));
        System.out.println(minInsertions("g"));
        System.out.println(minInsertions("no"));
        System.out.println("============动态规划状态压缩==================");
        System.out.println(minInsertions2("zzazz"));
        System.out.println(minInsertions2("mbadm"));
        System.out.println(minInsertions2("leetcode"));
        System.out.println(minInsertions2("g"));
        System.out.println(minInsertions2("no"));
    }
}
