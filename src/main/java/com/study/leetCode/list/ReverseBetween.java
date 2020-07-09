package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/7/9 17:44
 * @description: LeetCode-92-反转链表Ⅱ
 * 难度：中等
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class ReverseBetween {
    /**
     * 设pre为前驱节点，cur为当前节点。
     * 当我们遍历到2的时候，2.next=3，pre的next节点是2，这时候，我们让2的后继变成前驱的后继，也就是2.next=pre.next，然后顺序就会变成1-3-2-4-5 ，
     * 这个时候，pre节点还是1，而2.next就变成了4。这时候，我们再让2.next=pre.next，顺序就会变成1-4-3-2-5了。
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        //pre为1  head为2
        head = pre.next;
        for (int i = m; i < n; i++) {
            //nex为3
            ListNode nex = head.next;
            //head的下一个为3的下一个    head保存的是指到的坐标（交换到）
            head.next = nex.next;
            //nex的下一个就是1的下一个
            nex.next = pre.next;
            //pre的下一个就是1的下一个
            pre.next = nex;
        }
        return dummy.next;
    }
}
