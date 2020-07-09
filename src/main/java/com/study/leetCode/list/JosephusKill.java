package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/7/9 17:57
 * @description: 环形单链表约瑟夫问题
 * 据说著名犹太历史学家 Josephus有过以下的故事：在罗马人占领乔塔帕特后，39 个犹太人与Josephus及他的朋友躲到一个洞中，39个犹太人决定宁愿死也不要被敌人抓到，于是决定了一个自杀方式，41个人排成一个圆圈，由第1个人开始报数，每报数到第3人该人就必须自杀，然后再由下一个重新报数，直到剩下最后一个人时，那个人可以选择自己的命运。这就是著名的约瑟夫问题。现在请用单向环形链表描述该结构并呈现整个自杀过程。
 * <p>
 * 输入：一个环形单向链表的头节点head和报数的值m。
 * <p>
 * 返回：最后生存下来的节点，且这个节点自己组成环形单向链表，其他的节点都删掉。
 */
public class JosephusKill {
    /**
     * 普通解法比较简单，每删除一个节点都需要遍历m次，一共需要删除n-1个节点，所以时间复杂度为O(n*m)。
     * <p>
     * 1、如果链表为空或者节点数为1，或者m的值小于1，则不用调整就直接返回。
     * 2、在环形链表中遍历节点，报数达到m时，删除当前节点。
     * 3、删除节点后，剩下的节点继续连成环状，继续报数，继续删除。
     * 4、直到环形链表中只剩下一个节点，过程结束。
     *
     * @param head
     * @param m
     * @return
     */
    public ListNode josephusKill(ListNode head, int m) {
        if (head == null || m < 0) {
            return head;
        }
        ListNode last = head;
        //定位到最后一个节点
        while (head.next != last) {
            head = head.next;
        }
        int count = 0;
        while (head.next != head) {
            if (++count == m) {
                head.next = head.next.next;
                count = 0;
            } else {
                head = head.next;
            }
        }
        return head;
    }
}
