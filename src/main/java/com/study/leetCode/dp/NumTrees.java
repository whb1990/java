package main.java.com.study.leetCode.dp;

/**
 * @author: whb
 * @date: 2020/7/15 10:05
 * @description: LeetCode-96-不同的二叉搜索树
 * 难度：中等
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class NumTrees {
    /**
     * 动态规划
     * 思路：假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，…，n为根节点，
     * 当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，
     * 所以可得G(n) = G(0)G(n-1)+G(1)(n-2)+…+G(n-1)*G(0)
     *
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
