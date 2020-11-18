package main.java.com.study.leetCode.dp;

/**
 * @author： whb
 * @description： LeetCode-474-一和零
 * @date： 2020-11-18 15:51
 * 难度：中等
 * 标签：动态规划
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * 示例 1：
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 *
 * 示例 2：
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 *
 *
 * 提示：
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 */
public class FindMaxForm {
    /**
     * 动态规划
     * 第一步，要明确两点，[状态]和[选择]。
     *
     * 状态有三个， [背包对1的容量]、[背包对0的容量]和 [可选择的字符串]；选择就是把字符串[装进背包]或者[不装进背包]。
     *
     * 第二步，要明确dp数组的定义：
     *
     * 首先，[状态]有三个，所以需要一个三维的dp数组。
     *
     * dp[i][j][k]的定义如下：
     *
     * 若只使用前i个物品，当背包容量为j个0，k个1时，能够容纳的最多字符串数。
     *
     * 经过以上的定义，可以得到：
     *
     * base case为dp[0][..][..] = 0, dp[..][0][0] = 0。因为如果不使用任何一个字符串，则背包能装的字符串数就为0；如果背包对0，1的容量都为0，它能装的字符串数也为0。
     *
     * 最终想得到的答案就是dp[N][zeroNums][oneNums]，其中N为字符串的的数量。
     *
     * 第三步，根据选择，思考状态转移的逻辑：
     *
     * 注意，这是一个0-1背包问题，每个字符串只有一个选择机会，要么选择装，要么选择不装。
     *
     * 如果不把这第 i 个物品装入背包（等同于容量不足，装不下去），也就是说不使用strs[i]这一个字符串，那么当前的字符串数dp[i][j][k]应该等于dp[i - 1][j][k],继承之前的结果。
     *
     * 如果把这第 i 个物品装入了背包，也就是说使用 strs[i] 这个字符串，那么 dp[i][j] 应该等于 Max(dp[i - 1][j][k], dp[i][j - cnt[0]][k - cnt[1]] + 1)。(cnt 是根据strs[i]计算出来的。)
     *
     * 比如说，如果想把一个cnt = [1,2]的字符串装进背包(在容量足够的前提下)，只需要找到容量为
     *
     * [j - 1][k - 2]时候的字符串数再加上1，就可以得到装入后的字符串数了。
     *
     * 由于求的是最大值，所以取装和不装中能容纳的字符串总数更大的那一个。
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            int[] cnt = count(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (cnt[0] > j || cnt[1] > k) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - cnt[0]][k - cnt[1]] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    /**
     * 计算字符串中0和1的数量
     *
     * @param str
     * @return
     */
    private static int[] count(String str) {
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }

    /**
     * 当前的状态只跟上一层的状态有关，因此可以进行状态压缩
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public static int findMaxForm2(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] cnt = count(str);
            for (int i = m; i >= cnt[0]; i--) {
                for (int j = n; j >= cnt[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - cnt[0]][j - cnt[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
        System.out.println("=============动态规划优化==================");
        System.out.println(findMaxForm2(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(findMaxForm2(new String[]{"10", "0", "1"}, 1, 1));
    }
}
