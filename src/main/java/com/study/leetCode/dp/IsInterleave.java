package main.java.com.study.leetCode.dp;

/**
 * @author: whb
 * @date: 2020/7/21 11:23
 * @description: LeetCode-97-交错字符串
 * 难度：困难
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * <p>
 * 示例 1：
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 */
public class IsInterleave {
    /**
     * 动态规划，利用不同路径的题的解题思想
     * target的每个字符都是从s1（向下）或者s2（向右）拿到的,所以只要判断是否存在这条target路径即可；
     * <p>
     * 于是可定义boolean[][] dp ，dp[i][j]代表s1前i个字符与s2前j个字符拼接成s3的i+j字符，也就是存在目标路径能够到达i,j；
     * 状态方程：
     * <p>
     * 边界1：dp[0][0] = true;
     * 边界2：if i=0 : dp[0]dp[j] = s2[0-j) equals s3[0,j) 遇到false后面可以直接省略
     * 边界3：if j=0 : dp[i]dp[0] = s1[0-i) equals s3[0,i) 遇到false后面可以直接省略
     * <p>
     * 其他情况，到达（i，j）可能由（i-1,j）点向下一步，选择s1[i-1]到达；也可能由（i,j-1）点向右一步，选择s2[j-1]到达；
     * dp[i,j] = (dp[i-1][j] && s3[i+j-1] == s1[i-1]) || (dp[i][j-1] && s3[i+j-1] == s2[j-1])
     *
     * @param s2
     * @param s3
     * @return
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        //长度之和都不等，肯定无法由s1和s2交替组成s3
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    //边界条件：认为s1的前0个字符和s2的前0个字符，可以交替组成s3的前0个字符
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                            || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        //返回结果：s1的前n个字符和s2的前m个字符，可否交替组成s3的前n+m个字符
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        System.out.println(isInterleave(s1, s2, s3));
        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
