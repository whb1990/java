package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/3/31 16:06
 * @description: LeetCode-24-两两交换链表中的结点
 */
public class SwapPairs {

    /**
     * 递归法
     * 从链表的头节点 head 开始递归。
     * 每次递归都负责交换一对节点。由 firstNode 和 secondNode 表示要交换的两个节点。
     * 下一次递归则是传递的是下一对需要交换的节点。若链表中还有节点，则继续递归。
     * 交换了两个节点以后，返回 secondNode，因为它是交换后的新头。
     * 在所有节点交换完成以后，我们返回交换后的头，实际上是原始链表的第二个节点。
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        //1.终止条件：当前没有节点或只有一个节点，肯定就不需要交换了
        if (head == null || head.next == null) {
            return head;
        }
        //2.调用单元
        //需要交换的两个节点是head和head.next
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        //firstNode链接后面交换完成的子链表
        firstNode.next = swapPairs(secondNode.next);
        //secondNode链接firstNode
        secondNode.next = firstNode;
        //3.返回值：返回交换完成的头结点
        //secondNode变成了头结点
        return secondNode;
    }

    /**
     * 迭代法
     * 思路：把链表分成两部分，即奇数节点为一部分，偶数节点为一部分，A指的交换节点中的前面的节点，B指的是要交换节点中的后面的节点。在完成它们的交换，还得用prev记录A的前驱。
     * 算法：
     * 1、firstNode（即 A） 和 secondNode（即 B） 分别遍历偶数节点和奇数节点，即两步看作一步。
     * 2、交换两个节点：
     * firstNode.next = secondNode.next
     * secondNode.next = firstNode
     * 3、还需要更新 prev.next 指向交换后的头。
     * prev.next = secondNode
     * 4、迭代完成后得到最终的交换结果。
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prev = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }
}
