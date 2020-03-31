package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/3/31 11:28
 * @description: 链表结点定义
 */
public class ListNode {
    /**
     * 结点元素值
     */
    int val;
    /**
     * 后继结点
     */
    ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
}
