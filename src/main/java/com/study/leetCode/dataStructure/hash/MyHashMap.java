package main.java.com.study.leetCode.dataStructure.hash;

/**
 * @author: whb
 * @date: 2020/6/11 10:00
 * @description: LeetCode-706-设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射
 * <p>
 * 具体地说，你的设计应该包含以下的功能
 * <p>
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 * <p>
 * 示例：
 * <p>
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 * <p>
 * 注意：
 * <p>
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库。
 */
public class MyHashMap {
    private final double LOAD_FACTOR = 0.75f;
    private Node[] nodes;
    private int size;

    public MyHashMap() {
        nodes = new Node[16];
        size = 0;
    }

    /**
     * 计算哈希值（当length为2的幂次时，key & (length - 1) == key % length）
     *
     * @param key
     * @return
     */
    private int hash(int key) {
        return key & (nodes.length - 1);
    }

    /**
     * 每次再散列成原数组的两倍
     */
    private void rehash() {
        Node[] tmp = nodes;
        nodes = new Node[tmp.length << 1];
        size = 0;
        for (Node head : tmp) {
            for (Node p = head; p != null; p = p.next) {
                put(p.key, p.val);
            }
        }
    }

    /**
     * value will always be non-negative
     */
    public void put(int key, int val) {
        int hashKey = hash(key);
        //先遍历链表里是否已经存在相同key值，若存在则覆盖value
        for (Node p = nodes[hashKey]; p != null; p = p.next) {
            if (p.key == key) {
                p.val = val;
                return;
            }
        }
        //若链表中不存在则将节点插入在链表头部
        nodes[hashKey] = new Node(key, val, nodes[hashKey]);
        size++;
        //若当前size比例超过负载系统，则扩容
        if ((double) size / nodes.length > LOAD_FACTOR) {
            rehash();
        }
    }

    public int get(int key) {
        int hashKey = hash(key);
        for (Node p = nodes[hashKey]; p != null; p = p.next) {
            if (p.key == key) {
                return p.val;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hashKey = hash(key);
        Node newHead = new Node(-1, -1, nodes[hashKey]);
        for (Node p = newHead; p.next != null; p = p.next) {
            if (p.next.key == key) {
                p.next = p.next.next;
                size--;
                break;
            }
        }
        nodes[hashKey] = newHead.next;
    }

    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}
