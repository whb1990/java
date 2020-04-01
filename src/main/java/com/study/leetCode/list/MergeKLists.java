package main.java.com.study.leetCode.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: whb
 * @date: 2020/4/1 18:20
 * @description: LeetCode-23-合并k个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {

    /**
     * 利用堆排序的思想
     * 把链表一股脑的全放到堆里面，然后由堆根据节点的val自动排好序。
     * 这是一个小根堆，我们只需要每次输出堆顶的元素，直到整个堆为空即可。
     *
     * @param lists
     * @return
     */
    public ListNode mergeKListsHeap(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //创建一个堆，并设置元素的排序方式
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        //遍历链表数组，然后将每个链表的每个节点都放入堆中
        for (ListNode tmp : lists) {
            while (tmp != null) {
                queue.add(tmp);
                tmp = tmp.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        //从堆中不断取出元素，并将取出的元素串联起来
        while (!queue.isEmpty()) {
            curr.next = queue.remove();
            curr = curr.next;
        }
        curr.next = null;
        return dummy.next;
    }


    /**
     * 利用合并两个排序链表的思想
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            //两两合并
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                prev.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
