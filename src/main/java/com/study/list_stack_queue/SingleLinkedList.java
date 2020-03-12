package main.java.com.study.list_stack_queue;

/**
 * @author: whb
 * @date: 2020/3/11 19:34
 * @description: 单链表
 */
public class SingleLinkedList<E> {

    /**
     * 虚拟的头结点
     */
    private Node dummyHead;
    /**
     * 链表元素数量
     */
    private int size;

    public SingleLinkedList() {
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
        //设置虚拟头结点的是为了插入和删除方便，不需要判断第一个和最后一个位置
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        rangeCheck(index);
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public E remove(int index) {
        rangeCheck(index);
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.val;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void set(int index, E e) {
        rangeCheck(index);
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.val = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.val.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public int find(E e) {
        Node cur = dummyHead.next;
        int index = 0;
        while (cur != null) {
            if (cur.val.equals(e)) {
                return index;
            }
            cur = cur.next;
            index++;
        }
        return -1;
    }

    public void removeElement(E e) {
        remove(find(e));
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        for (int i = 0; i < 5; i++) {
            singleLinkedList.addFirst(i);
        }
        System.out.println(singleLinkedList);

        singleLinkedList.add(2, 666);
        System.out.println(singleLinkedList);

        singleLinkedList.remove(2);
        System.out.println(singleLinkedList);

        singleLinkedList.removeFirst();
        System.out.println(singleLinkedList);

        singleLinkedList.removeLast();
        System.out.println(singleLinkedList);

        singleLinkedList.removeElement(2);
        System.out.println(singleLinkedList);

        System.out.println(singleLinkedList.contains(3));

        singleLinkedList.set(1, 999);
        System.out.println(singleLinkedList);

        singleLinkedList.addLast(888);
        System.out.println(singleLinkedList);

        System.out.println(singleLinkedList.getFirst() + " " + singleLinkedList.getLast());
        System.out.println(singleLinkedList.size());
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
        public E val;
        public Node next;

        public Node(E val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(E val) {
            this(val, null);
        }

        public Node() {
            this(null);
        }

        @Override
        public String toString() {
            return val.toString();
        }
    }
}
