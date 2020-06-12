package main.java.com.study.leetCode.dataStructure.tree;

/**
 * @author: whb
 * @date: 2020/5/30 14:39
 * @description: LeetCode-104-二叉树最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class MaxDepth {

    /**
     * 自底向上递归
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 自顶向下递归
     *
     * @param root
     * @return
     */
    int result = 0;

    public int maxDepth2(TreeNode root) {
        if (root != null) {
            maxDepth(root, 1);
        }
        return result;
    }

    private void maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result = Math.max(result, depth);
        }
        maxDepth(root.left, depth + 1);
        maxDepth(root.right, depth + 1);
    }
}
