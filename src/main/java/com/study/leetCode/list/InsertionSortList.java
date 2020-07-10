package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/7/10 18:47
 * @description: LeetCode-147-对链表进行插入排序
 * 难度：中等
 * 对链表进行插入排序。
 * <p>
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * <p>
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 示例 2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class InsertionSortList {
    /**
     * 1、声明一个有虚拟头结点的空链表作为结果链表。
     * 2、每遍历一个结点，在结果链表中找到该结点的插入位置。
     * 3、将结点插入到对应的位置。
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = head;
        while (curr != null) {
            ListNode pre = dummy;
            while (pre.next != null && pre.next.val <= curr.val) {
                pre = pre.next;
            }
            ListNode next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = next;
        }
        return dummy.next;
    }
}
