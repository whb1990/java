package main.java.com.study.leetCode.dp;

/**
 * @author: whb
 * @date: 2020/7/30 16:05
 * @description: LeetCode-343-整数拆分
 * 难度：中等
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * <p>
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class IntegerBreak {
    /**
     * 动态规划
     * ①使用dp[i]表示正整数i的最大乘积，则dp[i]=max{dp[i-1]*1,(i-1)*1,dp[i-2]*2,(i-2)*2,...,dp[i-(i-1)]*(i-1),(i-(i-1))*(i-1)};
     * <p>
     * ②由①可知，dp[i]的状态就能转化为其他dp[1]...dp[i-1]可得，但事实并没有这么麻烦，因为这些正整数拆分最终总会拆分为2,3和少数的1.比如：
     * <p>
     * 2：1*1=1；
     * <p>
     * 3：1*2=2；
     * <p>
     * 4：2*2=4；
     * <p>
     * 5：2*3=6；
     * <p>
     * 因此调整状态转移方程为：
     * <p>
     * dp[i]=max(dp[i-2]*2,(i-2)*2,dp[i-3]*3,(i-3)*3);
     *
     * @param n
     * @return
     */
    public static int integerBreakDp(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }

    /**
     * 找规律
     * 正整数从1开始，但是1不能拆分成两个正整数之和，所以不能当输入。
     * <p>
     * 那么2只能拆成 1+1，所以乘积也为1。
     * <p>
     * 数字3可以拆分成 2+1 或 1+1+1，显然第一种拆分方法乘积大为2。
     * <p>
     * 数字4拆成 2+2，乘积最大，为4。
     * <p>
     * 数字5拆成 3+2，乘积最大，为6。
     * <p>
     * 数字6拆成 3+3，乘积最大，为9。
     * <p>
     * 数字7拆为 3+4，乘积最大，为 12。
     * <p>
     * 数字8拆为 3+3+2，乘积最大，为 18。
     * <p>
     * 数字9拆为 3+3+3，乘积最大，为 27。
     * <p>
     * 数字10拆为 3+3+4，乘积最大，为 36。
     * <p>
     * ....
     * <p>
     * 通过观察上面的规律，可以看出从5开始，数字都需要先拆出所有的3，一直拆到剩下一个数为2或者4，因为剩4就不用再拆了，拆成两个2和不拆没有意义，而且4不能拆出一个3剩一个1，这样会比拆成 2+2 的乘积小。
     * 所以先预处理n为2和3的情况，然后先将结果 res 初始化为1，然后当n大于4开始循环，结果 res 自乘3，n自减3，根据之前的分析，当跳出循环时，n只能是2或者4，再乘以 res 返回即可。
     *
     * @param n
     * @return
     */
    public static int integerBreak(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        return result * n;
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(3));
        System.out.println(integerBreak(10));
        System.out.println(integerBreakDp(2));
        System.out.println(integerBreakDp(3));
        System.out.println(integerBreakDp(10));
    }
}
