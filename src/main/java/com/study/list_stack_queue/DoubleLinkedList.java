package main.java.com.study.list_stack_queue;

/**
 * @author: whb
 * @date: 2020/3/12 14:31
 * @description: 双向链表
 */
public class DoubleLinkedList<E> {

    /**
     * 虚拟头结点
     */
    private Node dummyHead;

    /**
     * 链表长度
     */
    private int size;

    public DoubleLinkedList() {
        this.dummyHead = new Node();
        this.size = 0;
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

    public void add(int index, E e) {
        rangeCheck(index);
        Node insertNode = new Node(e);
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node next = prev.next;
        insertNode.prev = prev;
        insertNode.next = next != null ? next : null;
        prev.next = insertNode;
        if (next != null) {
            next.prev = insertNode;
        }
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E remove(int index) {
        rangeCheck(index);
        if (isEmpty()) {
            return null;
        }
        Node delNode = dummyHead;
        for (int i = 0; i <= index; i++) {
            delNode = delNode.next;
        }
        Node prev = delNode.prev;
        Node next = delNode.next;
        prev.next = next;
        if (next != null) {
            next.prev = prev;
        }
        size--;
        return delNode.val;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
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

        public Node(E val) {
            this(val, null, null);
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
        DoubleLinkedList<Integer> dulList = new DoubleLinkedList<>();
        for (int i = 0; i < 5; i++) {
            dulList.addLast(i);
        }
        System.out.println(dulList);

        dulList.removeLast();
        System.out.println(dulList);

        dulList.removeFirst();
        System.out.println(dulList);

        dulList.remove(1);
        System.out.println(dulList);

        dulList.addFirst(-1);
        dulList.add(1, 666);
        System.out.println(dulList);

    }
}
