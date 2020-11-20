package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/4/1 17:27
 * @description: LeetCode-25-K个一组翻转链表
 * 难度：困难
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class ReverseKGroup {
    /**
     * 1、链表分区为已翻转部分+待翻转部分+未翻转部分
     * 2、每次翻转前，要确定翻转链表的范围，这个必须通过 k 次循环来确定
     * 3、需记录翻转链表前驱和后继，方便翻转完成后把已翻转部分和未翻转部分连接起来
     * 4、初始需要两个变量 pre 和 end，pre 代表待翻转链表的前驱，end 代表待翻转链表的末尾
     * 5、经过k次循环，end 到达末尾，记录待翻转链表的后继 next = end.next
     * 6、翻转链表，然后将三部分链表连接起来，然后重置 pre 和 end 指针，然后进入下一次循环
     * 7、特殊情况，当翻转部分长度不足 k 时，在定位 end 完成后，end==null，已经到达末尾，说明题目已完成，直接返回即可
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        //虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //定义待反转链表的前驱结点和尾节点
        ListNode prev = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            //以k个结点分组
            for (int i = 0; end != null && i < k; i++) {
                end = end.next;
            }
            //不足k个时不处理
            if (end == null) {
                break;
            }
            //处理子链表
            ListNode start = prev.next;
            ListNode next = end.next;
            end.next = null;
            //翻转子链表
            prev.next = reverse(start);
            //将子链表前后串起来
            start.next = next;
            prev = start;
            end = prev;
        }
        return dummy.next;
    }

    /**
     * 反转链表
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

    /**
     * 解法二
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup2(b, k);
        return newHead;
    }

    /**
     * 反转区间 [a, b) 的元素，注意是左闭右开
     *
     * @param a
     * @param b
     * @return
     */
    private ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, next;
        pre = null;
        cur = a;
        next = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 返回反转后的头结点
        return pre;
    }
}
