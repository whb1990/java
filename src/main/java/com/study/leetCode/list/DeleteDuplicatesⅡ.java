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
}
