package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/6/6 16:20
 * @description: LeetCode-61-旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class RotateList {
    /**
     * 1.求出链表的长度len
     * 2.k = k%len取余就是我们要右移的距离。
     * 3.找到倒数第k个位置。可以使用双指针法。
     * 4.记录慢指针的next节点，这就是最后要返回的节点。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode ratoteList(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        //求出链表长度
        int listSize = 0;
        ListNode curr = head;
        while (curr != null) {
            listSize++;
            curr = curr.next;
        }
        k = k % listSize;
        if (k == 0) {
            return head;
        }
        //保存一下头节点
        //快慢指针
        ListNode node = head;
        curr = head;
        while (k > 0) {
            k--;
            curr = curr.next;
        }
        while (curr.next != null) {
            head = head.next;
            curr = curr.next;
        }
        //记录next的位置，也就是返回值的头节点
        ListNode result = head.next;
        //断开连接
        head.next = null;
        //后一段的末尾指向前一段的开头
        curr.next = node;
        return result;
    }
}
