package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/3/31 11:30
 * @description: LeetCode-160-相交链表
 * 例如以下示例中 A 和 B 两个链表相交于 c1：
 * <p>
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:    b1 → b2 → b3
 * 但是不会出现以下相交的情况，因为每个节点只有一个 next 指针，也就只能有一个后继节点，而以下示例中节点 c 有两个后继节点。
 * <p>
 * A:          a1 → a2       d1 → d2
 * ↘  ↗
 * c
 * ↗  ↘
 * B:    b1 → b2 → b3        e1 → e2
 * 要求时间复杂度为 O(N)，空间复杂度为 O(1)。如果不存在交点则返回 null。
 * <p>
 * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
 * <p>
 * 当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部开始访问链表 B；同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部开始访问链表 A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 * <p>
 * 如果不存在交点，那么 a + b = b + a，以下实现代码中 l1 和 l2 会同时为 null，从而退出循环。
 */
public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
