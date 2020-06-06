package main.java.com.study.leetCode.list;

/**
 * @author: whb
 * @date: 2020/3/31 18:12
 * @description: LeetCode-725-分隔链表
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * <p>
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * <p>
 * 返回一个符合上述规则的链表的列表。
 * <p>
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 * 示例 2：
 * <p>
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 *  
 * 提示:
 * <p>
 * root 的长度范围： [0, 1000].
 * 输入的每个节点的大小范围：[0, 999].
 * k 的取值范围： [1, 50].
 */
public class SplitListToParts {
    /**
     * 创建新列表
     * 如果链表有 N 个结点，则分隔的链表中每个部分中都有 n/k 个结点，且前 N\%k 部分有一个额外的结点。我们可以用一个简单的循环来计算 N。
     * 现在对于每个部分，我们已经计算出该部分有多少个节点：width + (i < remainder ? 1 : 0)。我们创建一个新列表并将该部分写入该列表。
     *
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode current = root;
        int listSize = 0;
        while (current != null) {
            listSize++;
            current = current.next;
        }
        int avgLen = listSize / k, rem = listSize % k;
        ListNode[] result = new ListNode[k];
        current = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = new ListNode(0), write = head;
            for (int j = 0; j < avgLen + (i < rem ? 1 : 0); ++j) {
                write = write.next = new ListNode(current.val);
                if (current != null) {
                    current = current.next;
                }
            }
            result[i] = head.next;
        }
        return result;
    }

    /**
     * 拆分链表
     *
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts2(ListNode root, int k) {
        int listSize = 0;
        ListNode current = root;
        while (current != null) {
            listSize++;
            current = current.next;
        }
        int avg = listSize / k;
        int rem = listSize % k;
        ListNode[] result = new ListNode[k];
        current = root;
        for (int i = 0; current != null && i < k; i++) {
            result[i] = current;
            int curSize = avg + (rem-- > 0 ? 1 : 0);
            for (int j = 0; j < curSize - 1; j++) {
                current = current.next;
            }
            ListNode next = current.next;
            current.next = null;
            current = next;
        }
        return result;
    }
}
