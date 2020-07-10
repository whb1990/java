package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/7/10 10:34
 * @description: LeetCode-143-重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * <p>
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class ReorderList {
    /**
     * 1.使用快慢指针找到中心点。（中心点需要是左边界）
     * 2.翻转后半部分链表。（递归翻转）
     * 3.将前半部分链表和翻转后的后半部分链表交错链接。
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //快慢指针，将链表切割成两段
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 取得翻转后的右部分链表，并与原链表断开
        ListNode right = reverseList(slow.next);
        //前段与后段断开
        slow.next = null;
        //连接两段链表
        ListNode p = head;
        while (p != null && right != null) {
            ListNode pNext = p.next;
            ListNode rNext = right.next;
            right.next = pNext;
            p.next = right;
            p = pNext;
            right = rNext;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return curr;
    }
}
