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

    /**
     * 迭代解法
     * 1、中序遍历：左根右。前序遍历：根左右；后序遍历：左右根。
     * 2、创建一个栈，将根节点和左节点依次入栈
     * 3、当左节点空时，进行出栈，添加到链表中。此时左节点在前，根节点在后
     * 4、遍历右节点
     * 5、重复2、3、4步，直到树为空
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
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
