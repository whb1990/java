package main.java.com.study.leetCode.list;

import main.java.com.study.leetCode.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: whb
 * @date: 2020/7/11 11:00
 * @description: LeetCode-面试题04.03-特定深度节点链表
 * 难度：中等
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 * 示例：
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 */
public class ListOfDepth {
    /**
     * 层序遍历+尾插法构建链表
     *
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<ListNode> list = new ArrayList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            ListNode head = null, tail = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode root = queue.poll();
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
                if (head == null) {
                    head = tail = new ListNode(root.val);
                } else {
                    tail.next = new ListNode(root.val);
                    tail = tail.next;
                }
            }
            list.add(head);
        }
        return list.toArray(new ListNode[list.size()]);
    }
}
