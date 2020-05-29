package main.java.com.study.leetCode.dataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: whb
 * @date: 2020/5/29 15:17
 * @description: LeetCode-94-二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 */
public class InorderTraversal {

    /**
     * DFS解法
     */
    List<Integer> dfsResult = new ArrayList<>();

    public List<Integer> inorderTraversalDFS(TreeNode root) {
        dfs(root);
        return dfsResult;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfsResult.add(root.val);
        dfs(root.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
