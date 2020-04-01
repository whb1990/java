package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/3/31 19:44
 * @description: LeetCode-面试题22-链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */
public class KthFromEnd {
    /**
     * 简洁版
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        if (fast == null) {
            return head;
        }
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow = slow.next;
        return slow;
    }

    /**
     * 完善版
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        if (k < 0) {
            return null;
        }
        //定义快指针
        ListNode fast = head;
        int i = k;
        for (; i > 0 && fast != null; i--) {
            fast = fast.next;
        }
        //说明链表长度小于k
        if (i > 0) {
            return null;
        }
        //定义慢指针
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
