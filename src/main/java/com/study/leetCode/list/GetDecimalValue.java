package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/7/10 15:45
 * @description: LeetCode-1290-二进制链表转整数
 * 难度：简单
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 * 示例 1：
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * <p>
 * 示例 2：
 * 输入：head = [0]
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * <p>
 * 示例 5：
 * 输入：head = [0,0]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 */
public class GetDecimalValue {
    /**
     * 解题思路：
     *
     * 分为两大步：
     *
     * （1）如何获得链表中的每个元素？
     *
     * 首先获得头结点指向的元素，然后头结点指向下一个节点，获得当前节点的元素值，一直循环到尾结点便可以获得所有节点指向的数值。while(head!=null){int value=head,val;head=head.next;}
     *
     * （2）如何将从链表中获得的二进制数值转化为十进制数？
     *
     * 101转化为10进制的过程：1->1;
     *
     * 10->2，即1<<2+head.val;
     *
     * 101->5,即二进制表示的10<<1+head.val
     *
     * 总结：每获得一个链表中的元素，就在原来10进制数的基础上左移1位再加当前链表元素的值
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result <<= 1;
            result += head.val;
            head = head.next;
        }
        return result;
    }
}
