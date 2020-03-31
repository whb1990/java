package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/3/31 14:45
 * @description: LeetCode-83-删除排序链表中的重复元素
 */
public class DeleteDuplicates {
    /**
     * 递归法
     * 找终止条件：当head指向链表只剩一个元素的时候，自然是不可能重复的，因此return
     * 想想应该返回什么值：应该返回的自然是已经去重的链表的头节点
     * 每一步要做什么：宏观上考虑，此时head.next已经指向一个去重的链表了，而根据第二步，我应该返回一个去重的链表的头节点。
     * 因此这一步应该做的是判断当前的head和head.next是否相等，如果相等则说明重了，返回head.next，否则返回head
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    /**
     * 迭代法
     * 由于输入的列表已排序，因此可以通过将结点的值与它之后的结点进行比较来确定它是否为重复结点。
     * 如果它是重复的，更改当前结点的 next 指针，以便它跳过下一个结点并直接指向下一个结点之后的结点。
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        //创建遍历指针current，初始化指向head
        ListNode current = head;
        //current.next == null表示遍历的指针到达链表尾部
        while (current != null && current.next != null) {
            ListNode next = current.next;
            //如果下一个元素的值和当前元素的值相等，就删除后后面的元素
            //特殊尾部节点分析：(最后一次循环)
            //相等的情况  【1 】（current）---> 【1】（current.next）  这个时候 current.next.next ==== null
            if (current.val == next.val) {
                current.next = next.next;
                next.next = null;
            } else {
                //不相等的情况  【1 】（current）---> 【2】（current.next）  这个时候 current 就移动到了尾部元素
                current = next;
            }
        }
        //为什么最后返回的是head呢？
        //current和head指向的是同一个地址，current用来操作列表，去除重复的。最后返回列表的最开始的地址，即头部head
        return head;
    }
}
