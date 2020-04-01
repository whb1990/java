package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/4/1 11:25
 * @description: 求链表中间的结点
 * 求单链表的中间结点，如果链表长度为偶数，返回两个结点的任意一个，若为奇数，则返回中间结点。
 */
public class KthFromMiddle {
    /**
     * 使用快慢指针，fast 指针每次移动两步，而 slow 指针每次移动一步，等到 fast 指针指向链表尾结点时，slow 指针指向的正好是链表的中间结点。
     *
     * @param head
     * @return
     */
    public ListNode getKthFromMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 如果链表长度为偶数，会返回两个中间节点的第一个
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
