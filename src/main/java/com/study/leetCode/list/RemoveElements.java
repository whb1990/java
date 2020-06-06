package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/6/6 15:30
 * @description: LeetCode-203-移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveElements {
    /**
     * 迭代法
     * 申请一个头结点cur，并使用一个变量dummy指向其初始的位置，cur 和 head同时向前遍历，head总比cur要快一个结点。
     * 当head中结点的值达到要求时（即head.val = val）,使较慢的cur.next直接指向head的下一个结点（当然也可以是null），此时cur不用继续向前，head向前一步后，
     * 通过达到的结点后，cur继续向前。最终返回dummy.next即可。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (head != null) {
            if (head.val == val) {
                cur.next = head.next;
            } else {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    /**
     * 递归法
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }
}
