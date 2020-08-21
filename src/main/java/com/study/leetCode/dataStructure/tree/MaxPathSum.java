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
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
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
        int left = dfs(root.left);
        int right = dfs(root.right);
        //当前节点为n,对于当前节点来说，最大值可以为n+left,n+right,n,n+left+right
        //上面四项中的一个，但是返回是不能返回第四个的，那种路径是不成立的
        int tmp = Math.max(root.val, Math.max(root.val + left, root.val + right));
        result = Math.max(result, tmp);
        int tmp2 = Math.max(tmp, root.val + left + right);
        result = Math.max(result, tmp2);
        return tmp;
    }
}
