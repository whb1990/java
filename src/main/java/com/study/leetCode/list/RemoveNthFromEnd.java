package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/3/31 15:24
 * @description: LeetCode-19-删除链表的倒数第N个结点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 */
public class RemoveNthFromEnd {
    /**
     * 快慢指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        //快指针移动n步之后慢指针再开始移动
        while (n-- > 0) {
            fast = fast.next;
        }
        //如果快指针为空，说明n=0
        if (fast == null) {
            return head.next;
        }
        ListNode slow = head;
        //要删除倒数第n个节点就要先找到它的前一个节点，即fast.next != null
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //删除倒数第n个节点
        slow.next = slow.next.next;
        return head;
    }
}
