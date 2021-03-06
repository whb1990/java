package main.java.com.study.leetCode.dp;

/**
 * @author： whb
 * @description： LeetCode-91-解码方法
 * @date： 2020-12-02 11:40
 * 难度：中等
 * 标签；字符串、动态规划
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 题目数据保证答案肯定是一个 32 位的整数。
 *
 * 示例 1：
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 示例 2：
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 示例 3：
 * 输入：s = "0"
 * 输出：0
 *
 * 示例 4：
 * 输入：s = "1"
 * 输出：1
 *
 * 示例 5：
 * 输入：s = "2"
 * 输出：1
 *
 *
 * 提示：
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 */
public class NumDecodings {
    /**
     * 动态规划
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        // dp[i][0] 以i为结尾 i和i-1不合并时的解码方式总数
        // dp[i][1] 以i为结尾 i和i-1合并时的解码方式总数
        int[][] dp = new int[s.length() + 1][2];
        //base case
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 1;
        dp[1][1] = 0;
        //状态转移
        for (int i = 2; i < dp.length; i++) {
            //当前位置是0，则必须和前一位合并
            if (s.charAt(i - 1) == '0') {
                if ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26) {
                    dp[i][1] = dp[i - 1][0];
                }
            } else {
                //前一位是0 不能合并
                if (s.charAt(i - 2) == '0') {
                    dp[i][0] = dp[i - 1][1];
                } else {
                    //前一位非0
                    if ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26) {
                        //和前一位合并
                        dp[i][1] = dp[i - 1][0];
                    }
                    //不合并
                    dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
                }
            }
        }
        return dp[dp.length - 1][0] + dp[dp.length - 1][1];
    }

    /**
     * 压缩空间
     * 上楼梯的复杂版？
     *     如果连续的两位数符合条件，就相当于一个上楼梯的题目，可以有两种选法：
     *         1.一位数决定一个字母
     *         2.两位数决定一个字母
     *         就相当于dp(i) = dp[i-1] + dp[i-2];
     *     如果不符合条件，又有两种情况
     *         1.当前数字是0：
     *             不好意思，这阶楼梯不能单独走，
     *             dp[i] = dp[i-2]
     *         2.当前数字不是0
     *             不好意思，这阶楼梯太宽，走两步容易扯着步子，只能一个一个走
     *             dp[i] = dp[i-1];
     * @param s
     * @return
     */
    public static int numDecodings2(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1] = s.charAt(i) == '0' ? 0 : dp[i];
            if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("1"));
        System.out.println("============一维Dp=============");
        System.out.println(numDecodings2("12"));
        System.out.println(numDecodings2("226"));
        System.out.println(numDecodings2("0"));
        System.out.println(numDecodings2("1"));
    }
}
