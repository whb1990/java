package main.java.com.study.leetCode.dataStructure.tree;

/**
 * @author: whb
 * @date: 2020/8/8 9:59
 * @description: LeetCode-99-恢复二叉搜索树
 * 难度：困难
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
}
