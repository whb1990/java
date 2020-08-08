package main.java.com.study.leetCode.dataStructure.tree;

import java.util.Stack;

/**
 * @author: whb
 * @date: 2020/8/8 9:59
 * @description: LeetCode-99-恢复二叉搜索树
 * 难度：困难
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 *
 * 示例 2:
 * 输入: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 *
 * 进阶:
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 */
public class RecoverTree {
    /**
     * 递归解法
     * 中序遍历过程中，记录错误两个错误排序节点，最后进行交换，只需要中序遍历一遍就可以了
     * O(n) 时间，O(n) 空间。
     */
    TreeNode t1, t2, pre;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre != null && pre.val > root.val) {
            if (t1 == null) {
                t1 = pre;
            }
            t2 = root;
        }
        pre = root;
        inorder(root.right);
    }

    /**
     * 栈解法
     * O(n) 时间，O(n) 空间。
     * 采用中序遍历的方法。一个合格的二叉搜索树在中序遍历后得到的序列一定是一个升序序列，
     * 当有两个点被交换时一定会出现两次前一个点或者一次（相邻节点被交换了）前一个点比后一个点大的情况，因此找到这两个点，
     * 然后保存一下，之后交换回来即可， 因为只用交换值
     *
     * @param root
     */
    public void recoverTree2(TreeNode root) {
        TreeNode t1 = null, t2 = null, pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (pre != null && pre.val > curr.val) {
                if (t1 == null) {
                    t1 = pre;
                }
                t2 = curr;
            }
            pre = curr;
            curr = curr.right;
        }
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }
}