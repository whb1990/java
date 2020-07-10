package main.java.com.study.leetCode.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: whb
 * @date: 2020/7/10 15:24
 * @description: LeetCode-面试题02.01.移除重复节点
 * 难度：简单
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * <p>
 * 示例2:
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 */
public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode curr = head;
        while (curr.next != null) {
            ListNode next = curr.next;
            if (!set.contains(next.val)) {
                set.add(next.val);
                curr = next;
            } else {
                curr.next = next.next;
            }
        }
        return head;
    }
}
