package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/4/1 19:46
 * @description: k个一组翻转链表，从尾部开始
 * 给定单链表的头结点 head，实现一个调整链表的函数，从链表尾部开始，以 K 个结点为一组进行逆序翻转，头部剩余结点不足一组时，不需要翻转。（不能使用队列或者栈作为辅助）
 */
public class ReverseKGroupPlus {
    public ListNode reverseKGroupPlus(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        //计算原链表的长度
        int length = getListSize(head);
        if (length < k) {
            return head;
        }
        //计算可以翻转的起始位置
        int offsetIndex = length % k;
        //如果原始链表刚好由k分为n组，可直接处理
        if (offsetIndex == 0) {
            return reverseKGroup(head, k);
        }
        //定义并找到可翻转的起始节点offest以及offset的前驱prev
        ListNode prev = head, offset = head;
        while (offsetIndex-- > 0) {
            prev = offset;
            offset = offset.next;
        }
        //将offset结点子链表进行翻转，再拼接回主链表
        prev.next = reverseKGroup(offset, k);
        return head;
    }

    /**
     * 计算链表长度
     *
     * @param head
     * @return
     */
    private int getListSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    /**
     * k个一组翻转链表
     *
     * @param head
     * @param k
     * @return
     */
    private ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; end != null && i < k; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = prev.next;
            ListNode next = end.next;
            prev.next = reverse(start);
            start.next = next;
            prev = start;
            end = prev;
        }
        return dummy.next;
    }

    /**
     * 翻转单链表
     *
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
