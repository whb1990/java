package main.java.com.study.leetCode.list;

import java.util.PriorityQueue;

/**
 * @author: whb
 * @date: 2020/7/10 17:30
 * @description: LeetCode-148-排序链表
 * 难度：中等
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class SortList {
    /**
     * 堆排序解法
     *
     * @param head
     * @return
     */
    public ListNode sortListHeap(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> {
            return o1.val - o2.val;
        });
        while (head != null) {
            queue.add(head);
            head = head.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!queue.isEmpty()) {
            ListNode tmp = queue.remove();
            tmp.next = null;
            curr.next = tmp;
            curr = curr.next;
        }
        return dummy.next;
    }
}
