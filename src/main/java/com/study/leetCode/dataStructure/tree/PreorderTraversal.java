package main.java.com.study.leetCode.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: whb
 * @date: 2020/6/11 19:24
 * @description: LeetCode-144-二叉树的前序遍历
 */
public class PreorderTraversal {
    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            preorderRecursion(root, result);
        }
        return result;
    }

    private void preorderRecursion(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            preorderRecursion(root.left, result);
            preorderRecursion(root.right, result);
        }
    }

    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalIteration(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                result.add(cur.val);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return result;
    }

}
