package main.java.com.study.leetCode.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;

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


}
