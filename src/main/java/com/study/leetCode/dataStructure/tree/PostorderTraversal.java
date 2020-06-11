package main.java.com.study.leetCode.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2020/6/11 19:48
 * @description: LeetCode-145-二叉树的中序遍历
 */
public class PostorderTraversal {

    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            postorderRecursion(root, result);
        }
        return result;
    }

    private void postorderRecursion(TreeNode root, List<Integer> result) {
        if (root != null) {
            postorderRecursion(root.left, result);
            postorderRecursion(root.right, result);
            result.add(root.val);
        }
    }
}
