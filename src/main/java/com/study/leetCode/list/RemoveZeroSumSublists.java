package main.java.com.study.leetCode.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: whb
 * @date: 2020/7/10 16:46
 * @description: LeetCode-1171-从链表中删除总和值为零的连续节点
 * 难度：中等
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * <p>
 * 删除完毕后，请你返回最终结果链表的头节点。
 * <p>
 * 你可以返回任何满足题目要求的答案。
 * <p>
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 * <p>
 * 示例 1：
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * <p>
 * 示例 2：
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 * <p>
 * 示例 3：
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 */
public class RemoveZeroSumSublists {
    /**
     * 遍历时记录前缀和及其位置，当某个前缀和重复出现时，两次出现之间的节点（不包括第一次出现的那个节点）都可以删掉，由于head也可以被删掉，所以在head之前再加一个节点。
     *
     * @param head
     * @return
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        ListNode curr = head;
        int sum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while (curr != null) {
            sum += curr.val;
            map.put(sum, curr);
            curr = curr.next;
        }
        sum = 0;
        curr = head;
        while (curr != null) {
            sum += curr.val;
            curr.next = map.get(sum).next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
