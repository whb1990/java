package main.java.com.study.leetCode.dp;

/**
 * @author： whb
 * @description： LeetCode-1143-最长公共子序列
 * @date： 2020-11-09 14:37
 * 难度：中等
 * 标签：动态规划
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 * 示例 1:
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 *
 * 示例 2:
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 *
 * 示例 3:
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *
 *
 * 提示:
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 */
public class LongestCommonSubsequence {
    /**
     * 第一步，一定要明确 dp 数组的含义。
     * 对于两个字符串的动态规划问题，套路是通用的。
     *
     * 比如说对于字符串 s1 和 s2，它们的长度分别是 m、n，一般来说都要构造一个这样的 DP table：int[][] dp = new int[m+1][n+1]。
     *
     * 这里为什么要加1，原因是你可以不加1，但是不加1你就会用其它限制条件来确保这个index是有效的，而当你加1之后你就不需要去判断只是让索引为0的行和列表示空串。
     *
     * 第二步，定义 base case
     * 我们专门让索引为0的行和列表示空串，dp[0][...] 和 dp[...][0] 都应该初始化为0，这就是base case。
     *
     * 第三部，找状态转移方程
     * 这是动态规划最难的一步，我们来通过案例推导出来。
     *
     * 对于 text1：abcde 和 text2：ace 两个字符串，我们定义两个指针进行遍历 i 和 j。
     *
     * 遍历 text1 长度为 m，定义指针 i，从 0～m。固定 i 指针（i == 1）位置，接下来开始遍历 text2 长度为 n，定义指针 j，从 0~n。
     *
     *
     * 第一次遍历 i = 1, j = 1，两个a相同所以 dp[1][1] = 1
     * 第二次遍历 i = 1, j = 2，a与c不等，也不能是0，这里需转换成 a 与 ac 最长子序列，这里需要把之前的关系传递过来，所以dp[1][2] = 1
     * 第三次遍历 i = 1, j = 3，a与e不相同，把之前的关系传递过来，所以dp[1][3] = 1
     * text2：ace 已经走完来第一轮，接下来text1：abcde 走到来b字符。
     *
     * 第四次遍历 i = 2, j = 1，就是需要比较ab与a的最长子串，把之前的关系传递过来，所以dp[2][1] = 1
     * 依次类推...（详看上图）
     *
     * 我们会发现遍历两个串字符，当不同时需要考虑两层遍历前面的值（关系传递），也就是左边和上边的其中较大的值，当想相同时，需要考虑各自不包含当前字符串的子序列长度，再加上1。
     *
     * 因此可以得出：
     * 现在对比的这两个字符不相同的，那么我们要取它的「要么是text1往前退一格，要么是text2往前退一格，两个的最大值」
     * dp[i + 1][j + 1] = Math.max(dp[i+1][j], dp[i][j+1]);
     *
     * 对比的两个字符相同，去找它们前面各退一格的值加1即可：dp[i+1][j+1] = dp[i][j] + 1;
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("abc", "def"));
    }
}
