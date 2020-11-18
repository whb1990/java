package main.java.com.study.leetCode.dp;

/**
 * @author： whb
 * @description： LeetCode-518-零钱兑换Ⅱ
 * @date： 2020-11-18 16:31
 * 难度：中等
 * 标签：动态规划
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 * 示例 1:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * 示例 2:
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 *
 * 示例 3:
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *
 * 注意:
 *
 * 你可以假设：
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 */
public class CoinChangeⅡ {
    /**
     * 动态规划
     *第一步要明确两点，「状态」和「选择」。
     *
     * 状态有两个，就是「背包的容量」和「可选择的物品」，选择就是「装进背包」或者「不装进背包」。
     *
     * 第二步要明确dp数组的定义。
     *
     * 首先看看刚才找到的「状态」，有两个，也就是需要一个二维dp数组。
     *
     * dp[i][j]的定义如下：
     *
     * 若只使用前i个物品，当背包容量为j时，有dp[i][j]种方法可以装满背包。
     *
     * 换句话说，若只使用coins中的前i个硬币的面值，若想凑出金额j，有dp[i][j]种凑法。
     *
     * 经过以上的定义，可以得到：
     *
     * base case 为dp[0][..] = 0， dp[..][0] = 1。因为如果不使用任何硬币面值，就无法凑出任何金额；如果凑出的目标金额为 0，那么“无为而治”就是唯一的一种凑法。
     *
     * 最终想得到的答案就是dp[N][amount]，其中N为coins数组的大小。
     *
     * 第三步，根据「选择」，思考状态转移的逻辑。
     *
     * 如果不把这第i个物品装入背包，也就是说不使用coins[i]这个面值的硬币，那么凑出面额j的方法数dp[i][j]应该等于dp[i-1][j]，继承之前的结果。
     *
     * 如果把这第i个物品装入了背包，也就是说使用coins[i]这个面值的硬币，那么dp[i][j]应该等于dp[i][j-coins[i-1]]。
     *
     * 首先由于i是从 1 开始的，所以coins的索引是i-1时表示第i个硬币的面值。
     *
     * dp[i][j-coins[i-1]]也不难理解，如果决定使用这个面值的硬币，那么就应该关注如何凑出金额j - coins[i-1]。
     *
     * 比如说，你想用面值为 2 的硬币凑出金额 5，那么如果你知道了凑出金额 3 的方法，再加上一枚面额为 2 的硬币，不就可以凑出 5 了嘛。
     *
     * 综上就是两种选择，而我们想求的dp[i][j]是「共有多少种凑法」，所以dp[i][j]的值应该是以上两种选择的结果之和：
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }

    /**
     * 通过观察可以发现，dp数组的转移只和dp[i][..]和dp[i-1][..]有关，所以可以压缩状态，进一步降低算法的空间复杂度
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 5));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{10}, 10));
        System.out.println("============动态规划状态压缩==============");
        System.out.println(coinChange(new int[]{1, 2, 5}, 5));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{10}, 10));
    }
}
