package main.java.com.study.leetCode.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: whb
 * @date: 2020/5/9 19:38
 * @description: LeetCode-138-复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的 深拷贝。
 * <p>
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * <p>
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * <p>
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * <p>
 * 示例 4：
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 */
public class CopyRandomList {
    /**
     * 利用HashMap存放遍历节点与复制节点
     * <p>
     * 遍历第一遍链表，不考虑链表之间的相互关系，仅仅生成所有节点，然后把它存到 HashMap 中，val 作为 key，复制Node 作为 value。
     * <p>
     * 遍历第二遍链表，将之前生成的节点取出来，更新它们的 next 和 random 指针。
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Map<Node, Node> map = new HashMap<>();
        Node tmp = head;
        while (tmp != null) {
            Node copyNode = new Node(tmp.val);
            map.put(tmp, copyNode);
            tmp = tmp.next;
        }
        tmp = head;
        while (tmp != null) {
            if (tmp.next != null) {
                map.get(tmp).next = map.get(tmp.next);
            }
            if (tmp.random != null) {
                map.get(tmp).random = map.get(tmp.random);
            }
            tmp = tmp.next;
        }
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
