package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/7/10 10:12
 * @description: LeetCode-86-分隔链表
 * 难度：中等
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Partition {
    /**
     * 双指针解法
     * 用两个指针，当小于 x的时候这个指针指向它，当大于等于 x的时候另一个指针指向它。
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode left = new ListNode(-1);
        ListNode tmpLeft = left;
        ListNode right = new ListNode(-1);
        ListNode tmpRight = right;
        while (head != null) {
            //保存当前节点的下一节点
            ListNode next = head.next;
            //然后将其断开，不断开容易形成环
            head.next = null;
            if (head.val < x) {
                tmpLeft.next = head;
                tmpLeft = tmpLeft.next;
            } else {
                tmpRight.next = head;
                tmpRight = tmpRight.next;
            }
            //重新连上
            head = next;
        }
        //让左边链表的最后一个指向右边链表
        tmpLeft.next = right.next;
        return left.next;
    }
}
