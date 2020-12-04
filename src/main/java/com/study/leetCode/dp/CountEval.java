package main.java.com.study.leetCode.dp;

/**
 * @author： whb
 * @description： LeetCode-面试题08.14.布尔运算
 * @date： 2020-12-04 9:08
 * 难度：中等
 * 标签：分治算法、区间DP
 * 给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
 *
 * 示例 1:
 *
 * 输入: s = "1^0|0|1", result = 0
 *
 * 输出: 2
 * 解释: 两种可能的括号方法是
 * 1^(0|(0|1))
 * 1^((0|0)|1)
 *
 * 示例 2:
 *
 * 输入: s = "0&0&0&1^1|0", result = 1
 *
 * 输出: 10
 * 提示：
 *
 * 运算符的数量不超过 19 个
 */
public class CountEval {
    /**
     * 分治算法
     *
     * @param s
     * @param result
     * @return
     */
    public static int countEval(String s, int result) {
        int len = s.length();
        char[] ch = s.toCharArray();
        //用于记忆化（缓存结果集）
        int[][][] cache = new int[len][len][];
        int[] res = backtrack(ch, 0, ch.length - 1, cache);
        return result == 0 ? res[0] : res[1];
    }

    private static int[] backtrack(char[] ch, int left, int right, int[][][] cache) {
        int[] res = new int[2];
        if (left >= right) {
            res[ch[left] - '0'] = 1;
            return res;
        }
        //缓存中存在就直接返回
        if (cache[left][right] != null) {
            return cache[left][right];
        }
        for (int i = left; i <= right; i++) {
            //遇到数字就跳过
            if (ch[i] == '0' || ch[i] == '1') {
                continue;
            }
            //如果遇到运算符号：分治，分别计算运算符左边和右边的结果
            int[] leftRes = backtrack(ch, left, i - 1, cache);
            int[] rightRes = backtrack(ch, i + 1, right, cache);
            switch (ch[i]) {
                case '&':
                    //结果为0 有三种情况： 0 0, 0 1, 1 0
                    //结果为1 有一种情况： 1 1
                    res[0] += leftRes[0] * rightRes[0] + leftRes[0] * rightRes[1] + leftRes[1] * rightRes[0];
                    res[1] += leftRes[1] * rightRes[1];
                    break;
                case '|':
                    //结果为0 有一种情况： 0 0
                    //结果为1 有三种情况： 0 1, 1 0, 1 1
                    res[0] += leftRes[0] * rightRes[0];
                    res[1] += leftRes[0] * rightRes[1] + leftRes[1] * rightRes[0] + leftRes[1] * rightRes[1];
                    break;
                case '^':
                    //结果为0 有两种情况： 0 0, 1 1
                    //结果为1 有两种情况： 0 1, 1 0
                    res[0] += leftRes[0] * rightRes[0] + leftRes[1] * rightRes[1];
                    res[1] += leftRes[0] * rightRes[1] + leftRes[1] * rightRes[0];
                    break;
                default:
                    break;
            }
        }
        //缓存结果集
        cache[left][right] = res;
        return res;
    }

    /**
     * 区间DP
     *
     * @param s
     * @param result
     * @return
     */
    public static int countEvalDp(String s, int result) {
        //特例
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return (s.charAt(0) - '0') == result ? 1 : 0;
        }
        char[] ch = s.toCharArray();
        //定义状态
        int[][][] dp = new int[ch.length][ch.length][2];
        //base case
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '0' || ch[i] == '1') {
                dp[i][i][ch[i] - '0'] = 1;
            }
        }
        //套区间dp模板
        //枚举区间长度len，跳步为2，一个数字一个符号
        for (int len = 2; len <= ch.length; len += 2) {
            //枚举区间起点，数字位，跳步为2
            for (int i = 0; i <= ch.length - len; i += 2) {
                //区间终点，数字位
                int j = i + len;
                //枚举分割点，三种 '&','|', '^'，跳步为2
                for (int k = i + 1; k <= j - 1; k += 2) {
                    if (ch[k] == '&') {
                        //结果为0 有三种情况： 0 0, 0 1, 1 0
                        //结果为1 有一种情况： 1 1
                        dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0] + dp[i][k - 1][0] * dp[k + 1][j][1] + dp[i][k - 1][1] * dp[k + 1][j][0];
                        dp[i][j][1] += dp[i][k - 1][1] * dp[k + 1][j][1];
                    }
                    if (ch[k] == '|') {
                        //结果为0 有一种情况： 0 0
                        //结果为1 有三种情况： 0 1, 1 0, 1 1
                        dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0];
                        dp[i][j][1] += dp[i][k - 1][0] * dp[k + 1][j][1] + dp[i][k - 1][1] * dp[k + 1][j][0] + dp[i][k - 1][1] * dp[k + 1][j][1];
                    }
                    if (ch[k] == '^') {
                        //结果为0 有两种情况： 0 0, 1 1
                        //结果为1 有两种情况： 0 1, 1 0
                        dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0] + dp[i][k - 1][1] * dp[k + 1][j][1];
                        dp[i][j][1] += dp[i][k - 1][1] * dp[k + 1][j][0] + dp[i][k - 1][0] * dp[k + 1][j][1];
                    }
                }
            }
        }
        return dp[0][ch.length - 1][result];
    }


    public static void main(String[] args) {
        System.out.println("==========分治算法=========");
        System.out.println(countEval("1^0|0|1", 0));
        System.out.println(countEval("0&0&0&1^1|0", 1));
        System.out.println("==========区间DP=========");
        System.out.println(countEvalDp("1^0|0|1", 0));
        System.out.println(countEvalDp("0&0&0&1^1|0", 1));
    }
}
