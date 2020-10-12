package main.java.com.study.leetCode.dp;

/**
 * @author: whb
 * @date: 2020/9/1 20:37
 * @description: LeetCode-486-预测赢家
 * 难度：中等
 * 标签：极小极大化、动态规划
 * 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 *
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 * 示例 1：
 * 输入：[1, 5, 2]
 * 输出：False
 * 解释：一开始，玩家1可以从1和2中进行选择。
 * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
 * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
 * 因此，玩家 1 永远不会成为赢家，返回 False 。
 *
 * 示例 2：
 * 输入：[1, 5, 233, 7]
 * 输出：True
 * 解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
 *      最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 True，表示玩家 1 可以成为赢家。
 *  
 *
 * 提示：
 * 1 <= 给定的数组长度 <= 20.
 * 数组里所有分数都为非负数且不会大于 10000000 。
 * 如果最终两个玩家的分数相等，那么玩家 1 仍为赢家。
 */
public class PredictTheWinner {
    /**
     * 1、定义状态
     * dp[i][j]表示先手玩家与后手玩家在nums[i...j]之间互相拿，先手玩家比后手玩家多的最大分数，注意：这是个差值，而且是个最大差值。
     * <p>
     * 2、转移方程
     * 对于先手玩家，在nums[i...j]之间，有两种拿法：
     * 2.1、拿开头的,也就是nums[i],现在要求dp[i][j],先手玩家手里有了nums[i]了，dp[i+1][j]表示什么呢？
     * 因为在nums[i+1...j],只能由后手玩家来选，其表示的是后手玩家在这个区间内，比先手玩家多的最大分数，
     * 反过来−dp[i+1][j]表示在这个区间内，先手玩家比后手玩家多的最大分数，那么，dp[i][j] = nums[i]+(-dp[i+1][j])；
     * <p>
     * 2.2、拿结尾的,也就是nums[j],现在要求dp[i][j],先手玩家手里有了nums[j]了，dp[i][j−1]表示什么呢？
     * 因为在nums[i...j−1]，只能由后手玩家来选，其表示的是后手玩家在这个区间内，比先手玩家多的最大分数,
     * 反过来−dp[i][j−1]表示在这个区间内，先手玩家比后手玩家多的最大分数，那么,dp[i][j−1]= nums[j]+(−dp[i][j−1])
     * 而每一步，都是最优解，那全局最优解，即先手玩家在每一步都想要最大化，即dp[i][j] = max[nums[i]+(-dp[i+1][j]),nums[j]+(-dp[i][j-1])]
     * 返回dp[0][n-1]表示在nums[0...n−1]范围内，先手玩家与后手玩家互相拿，先手玩家比后手玩家多的最大分数，只需要判断这个值是否大于等于0
     * 3、边界
     * dp[i][i]表示只存在一个数nums[i..i],显然，先手玩家拿走nums[i],其利益最大化，即dp[i][i] = nums[i]
     * 4、思路
     * 将i从n−1往前扩充到0，而j从i位置往后跑
     *
     * @param nums
     * @return
     */
    public static boolean predictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }

    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{1, 5, 2}));
        System.out.println(predictTheWinner(new int[]{1, 5, 233, 7}));
    }
}