package main.java.com.study.leetCode.list;

import main.java.com.study.leetCode.dataStructure.tree.TreeNode;

/**
 * @author: whb
 * @date: 2020/7/11 10:46
 * @description: LeetCode-114-二叉树展开为链表
 * 难度：中等
 * 标签：树、深度优先搜索
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class TreeToList {
    /**
     * 迭代
     * 展开的顺序其实就是二叉树的先序遍历。
     * 1、将左子树插入到右子树的地方；
     * 2、将原来的右子树插入到左子树的左右边节点；
     * 3、考虑新的右子树的根节点，一直重复上述过程，直到新的右子树为null。
     *
     * @param root
     */
    public void flattern(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    /**
     * 递归
     */
    public void flattern2(TreeNode root) {
        if (root == null) {
            return;
        }
        flattern2(root.left);
        flattern2(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

}
