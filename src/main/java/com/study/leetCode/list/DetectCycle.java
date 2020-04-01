package main.java.com.study.leetCode.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: whb
 * @date: 2020/4/1 19:27
 * @description: 检测单链表环的入口
 */
public class DetectCycle {

    /**
     * 双指针法
     * 使用 2 个指针，快指针每次走 2 步，慢指针每次走 1 步，如果链表有环，那么它们肯定可以在环中相遇。
     * <p>
     * 当快、慢两个指针首次相遇后，再用两个指针，指针 A 指向首次相遇的结点，指针 B 移动到单链表的头结点，然后两个指针分别每次向前移动 1 步，最终相遇的地方，就是单链表成环的入口。
     *
     * @param head
     * @return
     */
    public ListNode detectCycleDoublePointer(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    /**
     * 哈希法
     * 最容易想到的办法，如果单链表上有环，那必然有一个链表上靠后的结点的next指针指向了一个靠前的结点。
     * 以通过一次循环加一个 Set 的辅助集合，来在每次循环的时候，判断结点是否在 Set 中，如果没有则将结点存入 Set 并继续循环，有则找到了链表的入口。
     *
     * @param head
     * @return
     */
    public ListNode detectCycleHash(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (visited.contains(curr)) {
                return curr;
            }
            visited.add(curr);
            curr = curr.next;
        }
        return null;
    }
}
