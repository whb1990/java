package main.java.com.study.leetCode.dataStructure.ntree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author： whb
 * @description： LeetCode-589-N叉树的前序遍历
 * @date： 2020-10-30 15:13
 * 难度：简单
 * 标签：N叉树
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * 返回其前序遍历: [1,3,5,6,2,4]。
 */
public class Preorder {
    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderIteration(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node tmp = stack.pop();
                //头结点加入结果集
                res.add(tmp.val);
                //将该节点的子节点从右往左压入栈
                for (int i = tmp.children.size() - 1; i >= 0; i--) {
                    stack.push(tmp.children.get(i));
                }
            }
        }
        return res;
    }

    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
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
        res.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                helper(child, res);
            }
        }
    }
}
