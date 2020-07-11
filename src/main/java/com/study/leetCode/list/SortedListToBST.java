package main.java.com.study.leetCode.list;

import main.java.com.study.leetCode.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2020/7/11 9:59
 * @description: LeetCode-109-有序链表转二叉搜索树
 * 难度：中等
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class SortedListToBST {
    /**
     * 最基本的解法：取出链表中的元素值放到集合中，再将有序集合转二叉搜索树
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return convertToBST(list, 0, list.size() - 1);
    }

    private TreeNode convertToBST(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        TreeNode root = new TreeNode(list.get(middle));
        root.left = convertToBST(list, left, middle - 1);
        root.right = convertToBST(list, middle + 1, right);
        return root;
    }
}
