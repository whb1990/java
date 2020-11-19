package main.java.com.study.leetCode.dataStructure.tree;

/**
 * @author： whb
 * @description： LeetCode-230-二叉搜索树中第K小的元素
 * @date： 2020-11-19 9:09
 * 难度：中等
 * 标签：树、二分查找
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 */
public class KthSmallest {
    int n = 1;

    /**
     * 中序遍历+剪枝
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int left = kthSmallest(root.left, k);
        if (left != -1) {
            return left;
        }
        if (k == n) {
            return root.val;
        }
        n++;
        int right = kthSmallest(root.right, k);
        if (right != -1) {
            return right;
        }
        return -1;
    }
}
