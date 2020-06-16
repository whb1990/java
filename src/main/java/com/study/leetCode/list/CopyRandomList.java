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

    /**
     * 在解法一的基础上优化成一次遍历（同时复制节点，next节点，random节点并赋值）
     *
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return head;
        }
        Node tmp = head;
        Map<Node, Node> map = new HashMap<>();
        while (tmp != null) {
            if (!map.containsKey(tmp)) {
                Node copyNode = new Node(tmp.val);
                map.put(tmp, copyNode);
            }
            if (tmp.next != null) {
                if (!map.containsKey(tmp.next)) {
                    Node copyNext = new Node(tmp.next.val);
                    map.put(tmp.next, copyNext);
                }
                map.get(tmp).next = map.get(tmp.next);
            }
            if (tmp.random != null) {
                if (!map.containsKey(tmp.random)) {
                    Node copyRandom = new Node(tmp.random.val);
                    map.put(tmp.random, copyRandom);
                }
                map.get(tmp).random = map.get(tmp.random);
            }
            tmp = tmp.next;
        }
        return map.get(head);
    }

    /**
     * 1、生成所有的节点，并且分别插入到原有节点的后边
     * 2、更新插入节点的 random
     * 3、将新旧节点分离开来
     *
     * @param head
     * @return
     */
    public Node copyRandomList3(Node head) {
        if (head == null) {
            return null;
        }
        Node l1 = head;
        Node l2 = null;
        //生成所有的结点，并且分别插入到原有节点的后边
        while (l1 != null) {
            l2 = new Node(l1.val);
            l2.next = l1.next;
            l1.next = l2;
            l1 = l1.next.next;
        }
        //更新插入结点的random
        l1 = head;
        while (l1 != null) {
            if (l1.random != null) {
                l1.next.random = l1.random;
            }
            l1 = l1.next.next;
        }
        l1 = head;
        Node l2_head = l1.next;
        //将新旧节点拆开
        while (l1 != null) {
            l2 = l1.next;
            l1.next = l2.next;
            if (l2.next != null) {
                l2.next = l2.next.next;
            }
            l1 = l1.next;
        }
        return l2_head;
    }

    /**
     * 解法三利用原链表的 next 域把新生成的节点保存了起来。类似的，我们还可以利用原链表的 random 域把新生成的节点保存起来。
     * <p>
     * 主要还是三个步骤。
     * <p>
     * 生成所有的节点，将它们保存到原链表的 random 域，同时利用新生成的节点的 next 域保存原链表的 random。
     * 更新新生成节点的 random 指针。
     * 恢复原链表的 random 指针，同时更新新生成节点的 next 指针。
     *
     * @param head
     * @return
     */
    public Node copyRandomList4(Node head) {
        if (head == null) {
            return null;
        }
        Node l1 = head;
        Node l2 = null;
        //生成所有的节点，将它们保存到原链表的random域
        //同时利用新生成的节点的next域保存原链表的random域
        while (l1 != null) {
            l2 = new Node(l1.val);
            l2.next = l1.random;
            l1.random = l2;
            l1 = l1.next;
        }
        l1 = head;
        //更新新生成节点的random域
        while (l1 != null) {
            l2 = l1.random;
            l2.random = l2.next != null ? l2.next.random : null;
            l1 = l1.next;
        }
        l1 = head;
        Node l2_head = l1.random;
        //恢复原链表的random指针，同时更新新生成节点的next指针
        while (l1 != null) {
            l2 = l1.random;
            l1.random = l2.next;
            l2.next = l1.next != null ? l1.next.random : null;
            l1 = l1.next;
        }
        return l2_head;
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
