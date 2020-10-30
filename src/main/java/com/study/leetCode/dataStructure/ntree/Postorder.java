package main.java.com.study.leetCode.dataStructure.ntree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author： whb
 * @description： LeetCode-590-N叉树的后序遍历
 * @date： 2020-10-30 15:55
 * 难度：简单
 * 标签：N叉树
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 */
public class Postorder {
    /**
     * 迭代
     */
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node tmp = stack.pop();
                if (tmp.children == null) {
                    res.add(tmp.val);
                    continue;
                }
                stack.push(new Node(tmp.val));
                for (int i = tmp.children.size() - 1; i >= 0; i--) {
                    stack.push(tmp.children.get(i));
                }
            }
        }
        return res;
    }

    /**
     * 递归
     */
    public List<Integer> postorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            helper(root, res);
        }
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            helper(child, res);
        }
        res.add(root.val);
    }
}
