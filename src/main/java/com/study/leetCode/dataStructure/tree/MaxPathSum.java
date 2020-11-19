package main.java.com.study.leetCode.dataStructure.tree;

/**
 * @author: whb
 * @date: 2020/8/21 14:14
 * @description: LeetCode-124-二叉树中最大的路径和
 * 难度：困难
 * 标签：树、深度优先搜索
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 *
 * 示例 2:
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 */
public class MaxPathSum {
    /**
     * 1、思路
     * 路径每到一个节点，有 3 种选择： 1. 停留在当前节点。2. 走到左子节点。3. 走到右子节点。
     *
     * 走到子节点，又面临这 3 种选择，所以可以用递归。
     *
     * 注意！不能走进一个分支又掉头回来走另一个分支，路径会重叠。
     *
     *
     * 2、定义递归函数
     * 路径走入一个子树，能从中捞取的最大收益，是我们关心的，我们不关心具体怎么走，具体怎么走是交给子递归帮你算的，做递归题需要屏蔽递归的细节！
     *
     * 定义 dfs 函数：求出当前子树能向父节点 “提供” 的最大路径和。即，一条从父节点延伸下来的路径，能在当前子树中获得的最大收益。它分为三种情况：
     *
     * 1）路径停在当前子树的根节点，收益：root.val
     * 2）走入左子树，最大收益：root.val + dfs(root.left)
     * 3）走入右子树，最大收益：root.val + dfs(root.right)
     * 这对应了前面讲的三种选择，最大收益取三者中最大:root.val + max(dfs(root.left), dfs(root.right))。
     *
     * 再次提醒：一条从父节点延伸下来的路径，不能走入左子树，又掉头走右子树，不能两头收益。
     *
     * 4）当遍历到null节点时，收益为 0，返回 0。
     *
     * 如果一个子树提供的最大路径和为负，路径走入它，收益不增反减，我们希望该子树不被考虑，让它返回 0，像砍掉一样。
     *
     * 子树中的内部路径要包含根节点
     * 题目说，路径不一定经过根节点，说明，最大路径和可能产生于局部子树中。
     *
     * 因此，每次递归调用，都求一下「当前子树内部的最大路径和」，每个子树都求，取最大的那个。
     *
     * 注意，一个子树内部的路径，要包含当前子树的根节点。因为如果不包括根节点，那还算什么当前子树的路径，而是当前子树的子树的内部路径。
     *
     * 所以，一个子树内部的最大路径和 = 左子树提供的最大路径和 + 根节点值 + 右子树提供的最大路径和。
     * 即 int max = dfs(root.left) + root.val + dfs(root.right);
     */
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return result;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        //返回当前子树的最大值
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        result = Math.max(result, leftMax + root.val + rightMax);
        return Math.max(leftMax, rightMax) + root.val;
    }
}
