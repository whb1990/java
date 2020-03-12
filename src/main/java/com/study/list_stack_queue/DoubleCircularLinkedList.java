package main.java.com.study.list_stack_queue;

/**
 * @author: whb
 * @date: 2020/3/12 15:58
 * @description: 双向循环链表
 */
public class DoubleCircularLinkedList<E> {
    /**
     * 头结点
     */
    private Node dummyHead;
    /**
     * 尾结点
     */
    private Node tail;
    /**
     * 链表长度
     */
    private int size;

    public DoubleCircularLinkedList() {
        //自成一环
        dummyHead = new Node();
        tail = dummyHead;
        dummyHead.next = tail;
        dummyHead.prev = tail;
        tail.prev = dummyHead;
        tail.next = dummyHead;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void rangeCheck(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is Illegal !");
        }
    }

    public void add(E e) {
        Node node = new Node(e);
        node.prev = tail;
        node.next = dummyHead;
        tail.next = node;
        dummyHead.prev = node;
        tail = node;
        size++;
    }

    public void add(int index, E e) {
        rangeCheck(index);
        Node insertNode = new Node(e);
        if (index == size) {
            add(e);
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node next = prev.next;
        insertNode.prev = prev;
        insertNode.next = next;
        prev.next = insertNode;
        next.prev = insertNode;
        size++;
    }

    public E get(int index) {
        rangeCheck(index);
        Node cur = dummyHead;
        if (index < (size << 1)) {
            for (int i = 0; i < index + 1; i++) {
                cur = cur.next;
            }
            return cur.val;
        } else {
            for (int i = 0; i < index + 1; i++) {
                cur = cur.prev;
            }
            return cur.val;
        }
    }

    public E removeLast() {
        E ret = tail.val;
        tail.prev.next = tail.next;
        tail.next.prev = tail.prev;
        tail = tail.prev;
        size--;
        return ret;
    }

    public E remove(int index) {
        rangeCheck(index);
        if (index == size - 1) {
            return removeLast();
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        Node next = delNode.next;
        prev.next = next;
        next.prev = prev;
        size--;
        return delNode.val;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != dummyHead) {
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    private class Node {
        /**
         * 结点值
         */
        private E val;
        /**
         * 前驱结点
         */
        private Node prev;
        /**
         * 后继结点
         */
        private Node next;

        public Node(E val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        public Node(E e) {
            this(e, null, null);
        }

        public Node() {
            this(null);
        }

        @Override
        public String toString() {
            return val.toString();
        }
    }

    public static void main(String[] args) {
        DoubleCircularLinkedList<Integer> myLinkedList = new DoubleCircularLinkedList<>();
        for (int i = 0; i < 5; i++) {
            myLinkedList.add(i);
        }
        myLinkedList.add(0, -1);
        myLinkedList.add(1, 999);
        myLinkedList.removeLast();
        System.out.println(myLinkedList);
        myLinkedList.remove(3);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.tail.next.next.val);
        System.out.println(myLinkedList.dummyHead.next.next.val);
        System.out.println(myLinkedList.tail.prev.val);
        System.out.println(myLinkedList.get(4));
    }
}
