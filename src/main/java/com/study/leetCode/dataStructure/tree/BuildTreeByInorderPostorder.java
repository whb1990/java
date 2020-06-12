package main.java.com.study.leetCode.dataStructure.tree;

import java.util.Arrays;

/**
 * @author: whb
 * @date: 2020/6/12 16:59
 * @description: LeetCode-106-从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTreeByInorderPostorder {
    /**
     * 后序遍历序列的最后一个元素一定是新建的二叉树的根节点。
     * 第1轮：根据后序遍历序列，节点"3"一定位于新建二叉树的根节点的位置，再到中序遍历序列找节点"3"的位置，得到左右子树划分。
     * 第2轮：根据后序遍历序列，节点"20"一定位于新建二叉树的根节点的位置，再到中序遍历序列找节点"20"的位置，得到左右子树划分。
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        for (int i = 0; i < inorder.length; i++) {
            if (postorder[postorder.length - 1] == inorder[i]) {
                // Arrays.copyOfRange() 方法的第 1 个参数是源数组
                // 第 2 个参数是源数组的起始位置（可以取到）
                // 第 3 个参数是源数组的终止位置（不可以取到）
                root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length - 1));
            }
        }
        return root;
    }
}
