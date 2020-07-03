package main.java.com.study.leetCode.dataStructure.array;

/**
 * @author: whb
 * @date: 2020/7/3 19:06
 * @description: LeetCode-714-买卖股票的最佳时机含手续费
 * 难度：中等
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 示例 1:
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 * <p>
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 */
public class MaxProfitⅥ {
    public static int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) {
            return 0;
        }
        //当持有股票的的最大利润
        int hold = -prices[0] - fee;
        //当不持有股票的最大利润
        int cash = 0;
        for (int i = 1; i < prices.length; i++) {
            //持有股票
            hold = Math.max(hold, cash - prices[i] - fee);
            //不持有股票
            cash = Math.max(cash, hold + prices[i]);
        }
        return cash;
    }

    /**
     * 动态规划
     *
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfitDP(int[] prices, int fee) {
        if (prices.length <= 1) {
            return 0;
        }
        //定义二维数组，dp[i][0]表示不持有股票时的收益，dp[i][1]代表持有股票时的收益
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(maxProfitDP(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
