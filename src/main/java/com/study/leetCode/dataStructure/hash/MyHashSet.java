package main.java.com.study.leetCode.dataStructure.hash;

/**
 * @author: whb
 * @date: 2020/6/6 18:43
 * @description: LeetCode-705-设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合
 * <p>
 * 具体地说，你的设计应该包含以下的功能
 * <p>
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * <p>
 * 示例:
 * <p>
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);
 * hashSet.contains(2);    // 返回  false (已经被删除)
 * <p>
 * 注意：
 * <p>
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 */
public class MyHashSet {

    private Node[] array;
    private int usedSize;

    public MyHashSet() {
        this.array = new Node[10];
        this.usedSize = 0;
    }

    public void add(int key) {
        //1. 得到key对应的唯一的hashCode()所得到的下标
        int index = key % array.length;
        //2. 遍历数组中index下标对应的桶
        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                return;
            }
        }
        //3. 循环结束，桶中不存在此元素，进行头插法入桶
        Node node = new Node(key);
        node.next = array[index];
        array[index] = node;
        usedSize++;
    }

    public void remove(int key) {
        int index = key % array.length;
        if (array[index] == null) {
            return;
        }
        Node cur = array[index];
        //要删除的节点正好是桶的头节点
        if (cur.key == key) {
            array[index] = cur.next;
            usedSize--;
            return;
        }
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                usedSize--;
                return;
            }
            cur = cur.next;
        }
    }

    public boolean contains(int key) {
        int index = key % array.length;
        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                return true;
            }
        }
        return false;
    }

    class Node {
        public int key;
        public Node next;

        public Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }

        public Node(int key) {
            this(key, null);
        }

        public Node() {
        }
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
    }
}
