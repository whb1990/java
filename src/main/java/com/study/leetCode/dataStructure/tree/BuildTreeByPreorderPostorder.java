package main.java.com.study.leetCode.dataStructure.tree;

/**
 * @author: whb
 * @date: 2020/8/8 14:20
 * @description: LeetCode-889-根据前序和后序遍历构造二叉树
 * 难度：中等
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 * <p>
 *  pre 和 post 遍历中的值是不同的正整数。
 * <p>
 * 示例：
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 */
public class BuildTreeByPreorderPostorder {
    /**
     * 解题思路：
     * 通过前序遍历的结果构建二叉树（使用递归）
     * 通过后序遍历的结果验证是否到达了左右叶子结点（当前节点 root.val == post[index]）。
     * 前序遍历 先递归创建节点
     * 在左右孩子递归完成后，将后序遍历的的索引后移一位
     */
    //// 新建两个下标，分别指向前序遍历结果和后序遍历结果
    int preIndex = 0, postIndex = 0;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        // 新建一个父节点，建立之后 preIndex 向右移动一位
        TreeNode root = new TreeNode(pre[preIndex++]);
        // （前提条件，父节点不是叶子节点）建立左子树
        if (root.val != post[postIndex]) {
            root.left = constructFromPrePost(pre, post);
        }
        // （前提条件，父节点不是叶子节点）建立右子树
        if (root.val != post[postIndex]) {
            root.right = constructFromPrePost(pre, post);
        }
        // 这里的 postIndex++ 很关键（理解）
        postIndex++;
        // 走到这一步的时候，一般情况会是：没有左右孩子（叶子节点 root.val == post[postIndex]）
        // 或者左右孩子的递归已经返回（那么此时 root.val 必定等于 post[postIndex] 后序递归：左右中）
        return root;
    }
}
