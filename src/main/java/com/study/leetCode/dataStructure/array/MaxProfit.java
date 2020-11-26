package main.java.com.study.leetCode.dataStructure.array;

/**
 * @author: whb
 * @date: 2020/7/1 17:43
 * @description: LeetCode-121-买卖股票的最佳时机
 * 难度：简单
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfit {
    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public static int maxProfitDp(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int[] dp = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        return dp[prices.length - 1];
    }

    /**
     * 贪心算法
     * 首先设两个数，一个保存最小数，一个保存结果（即最大差值）
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int min = prices[0], res = 0;
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfitDp(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfitDp(new int[]{7, 6, 4, 3, 1}));
    }
}
