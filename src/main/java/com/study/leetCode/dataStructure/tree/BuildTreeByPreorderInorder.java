package main.java.com.study.leetCode.dataStructure.tree;

import java.util.Arrays;

/**
 * @author: whb
 * @date: 2020/6/12 17:24
 * @description: LeetCode-105-从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTreeByPreorderInorder {
    /**
     * 先序遍历序列的第一个元素一定是新建的二叉树的根节点。
     * 第1轮：根据先序遍历序列，节点"3"一定位于新建二叉树的根节点的位置，再到中序遍历序列找节点"3"的位置，得到左右子树划分。
     * 第2轮：根据先序遍历序列，节点"20"一定位于新建二叉树的根节点的位置，再到中序遍历序列找节点"20"的位置，得到左右子树划分。
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return root;
    }
}
