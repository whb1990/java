package main.java.com.study.leetCode.list;

import java.util.Stack;

/**
 * @author: whb
 * @date: 2020/3/31 17:11
 * @description: LeetCode-234-回文链表
 * 难度：简单
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 */
public class Palindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        cut(head, slow);
        return isEqual(head, reverse(slow));
    }

    /**
     * 截断链表
     *
     * @param head
     * @param cutNode
     */
    private void cut(ListNode head, ListNode cutNode) {
        while (head.next != cutNode) {
            head = head.next;
        }
        head.next = null;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return curr;
    }

    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    /**
     * 解法二
     * 利用栈来做辅助，把链表的节点全部入栈，再一个个出栈与链表进行对比
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        while (!stack.isEmpty()) {
            ListNode tmp = stack.pop();
            if (tmp.val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 解法三
     * 让链表的后半部分入栈就可以了，然后把栈中的元素与链表的前半部分对比
     *
     * @param head
     * @return
     */
    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //快慢指针
        ListNode slow = head, fast = head;
        Stack<ListNode> stack = new Stack<>();
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            ListNode tmp = stack.pop();
            if (tmp.val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
