package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/3/31 11:39
 * @description: LeetCode-206-反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {
    /**
     * 递归
     * 终止条件是当前节点或者下一个节点==null
     * 在函数内部，改变节点的指向，也就是 head 的下一个节点指向 head 递归函数那句
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

    /**
     * 迭代法
     * 申请两个指针，第一个指针叫 pre，最初是指向 null 的。
     * 第二个指针 cur 指向 head，然后不断遍历 cur。
     * 每次迭代到 cur，都将 cur 的 next 指向 pre，然后 pre 和 cur 前进一位。
     * 都迭代完了(cur 变成 null 了)，pre 就是最后一个节点了。
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        /**
         * 前一个结点
         */
        ListNode prev = null;
        /**
         * 当前结点
         */
        ListNode cur = head;
        ListNode tmp;
        while (cur != null) {
            //记录当前节点的下一个节点
            tmp = cur.next;
            //然后将当前节点指向pre
            cur.next = prev;
            //pre和cur节点都前进一位
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
