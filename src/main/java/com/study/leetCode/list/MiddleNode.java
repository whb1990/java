package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/4/1 11:25
 * @description: LeetCode-876-链表的中间结点
 * 难度：简单
 * 求给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * <p>
 * 示例 2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 */
public class MiddleNode {
    /**
     * 使用快慢指针，fast 指针每次移动两步，而 slow 指针每次移动一步，等到 fast 指针指向链表尾结点时，slow 指针指向的正好是链表的中间结点。
     *
     * @param head
     * @return
     */
    public ListNode getKthFromMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 如果链表长度为偶数，会返回两个中间节点的第一个
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
