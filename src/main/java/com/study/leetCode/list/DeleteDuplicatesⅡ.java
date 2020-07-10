package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/7/10 14:27
 * @description: LeetCode-82-删除排序列表中的重复元素Ⅱ
 * 难度：中等
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class DeleteDuplicatesⅡ {
    /**
     * 递归解法一
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //判断是否是相等的值与下一个
        if (head.val == head.next.val) {
            ListNode next = head.next;
            //如果重复的值就向下循环找到不重复的那个值然后继续深搜进行向下判断返回使其能相连接
            do {
                next = next.next;
            } while (next != null && head.val == next.val);
            return deleteDuplicates(next);
        }
        //不重复就将当前的head连接下一个返回并继续深搜
        head.next = deleteDuplicates(head.next);
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        //如果是这种情况
        //      1 --> 1 --> 1 --> 2 --> 3
        //     head  next
        //1.则需要移动next直到出现与当前head.value不相等的情况（含null）
        //2.并且此时的head已经不能要了，因为已经head是重复的节点
        //--------------else-------------
        //      1 --> 2 --> 3
        //     head  next
        //3.如果没有出现1的情况，则递归返回的节点就作为head的子节点
        if (head.val == next.val) {
            //1
            while (next != null && head.val == next.val) {
                next = next.next;
            }
            //2
            return deleteDuplicates(next);
        }
        //3
        head.next = deleteDuplicates(head.next);
        return head;
    }

    /**
     * 迭代法
     * p 是游标，不断的向后遍历寻找符合条件的位置。
     * 重点在于 prev， 如果 prev 之后有重复元素，prev 是不会移动的。
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates3(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode p = head;
        while (p != null) {
            if (p.next == null || p.next.val != p.val) {
                prev.next = p;
                prev = prev.next;
            } else {
                while (p.next != null && p.next.val == p.val) {
                    p = p.next;
                }
            }
            p = p.next;
        }
        //清理脏借点
        prev.next = null;
        return dummy.next;
    }
}
