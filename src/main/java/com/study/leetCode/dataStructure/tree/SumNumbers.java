package main.java.com.study.leetCode.dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author： whb
 * @description： LeetCode-129-求根到叶子节点数字之和
 * @date： 2020-10-29 10:53
 * 难度：中等
 * 标签：树、深度优先搜索、广度优先搜索
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 */
public class SumNumbers {
    /**
     * 深度搜索优先
     * 从根节点开始，遍历每个节点，如果遇到叶子节点，则将叶子节点对应的数字加到数字之和。
     * 如果当前节点不是叶子节点，则计算其子节点对应的数字，然后对子节点递归遍历。
     *时间复杂度：O(n)，其中 n 是二叉树的节点个数。对每个节点访问一次。
     *
     * 空间复杂度：O(n)，其中 n 是二叉树的节点个数。空间复杂度主要取决于递归调用的栈空间，递归栈的深度等于二叉树的高度，最坏情况下，二叉树的高度等于节点个数，空间复杂度为 O(n)。
     * @param root
     * @return
     */
    public int sumNumbersDFS(TreeNode root) {
        return dfsHelper(root, 0);
    }

    private int dfsHelper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 10 * sum + root.val;
        }
        return dfsHelper(root.left, 10 * sum + root.val) + dfsHelper(root.right, 10 * sum + root.val);
    }

    /**
     * 广度优先搜索
     * 使用广度优先搜索，需要维护两个队列，分别存储节点和节点对应的数字。
     *
     * 初始时，将根节点和根节点的值分别加入两个队列。每次从两个队列分别取出一个节点和一个数字，进行如下操作：
     *
     * 如果当前节点是叶子节点，则将该节点对应的数字加到数字之和；
     *
     * 如果当前节点不是叶子节点，则获得当前节点的非空子节点，并根据当前节点对应的数字和子节点的值计算子节点对应的数字，然后将子节点和子节点对应的数字分别加入两个队列。
     *
     * 搜索结束后，即可得到所有叶子节点对应的数字之和。
     *
     * 时间复杂度：O(n)，其中 n 是二叉树的节点个数。对每个节点访问一次。
     *
     * 空间复杂度：O(n)，其中 n 是二叉树的节点个数。空间复杂度主要取决于队列，每个队列中的元素个数不会超过 n。
     * @param root
     * @return
     */
    public int sumNumbersBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        int res = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode cur = nodeQueue.poll();
            int num = numQueue.poll();
            if (cur.left == null && cur.right == null) {
                res += num;
            } else {
                if (cur.left != null) {
                    nodeQueue.offer(cur.left);
                    numQueue.offer(10 * num + cur.left.val);
                }
                if (cur.right != null) {
                    nodeQueue.offer(cur.right);
                    numQueue.offer(10 * num + cur.right.val);
                }
            }
        }
        return res;
    }
}
