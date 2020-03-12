package main.java.com.study.list_stack_queue;

/**
 * @author: whb
 * @date: 2020/3/12 17:13
 * @description: 单向链表实现队列
 * 注意为了dequeue的方便，增加了一个tail指针指向尾节点；
 * 注意队列为空的情况要特判
 */
public class SingleListQueue<E> {
    /**
     * 头结点、尾结点
     */
    private Node head, tail;
    /**
     * 队列长度
     */
    private int size;

    public SingleListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't dequeue from an empty queue.");
        }
        Node delNode = head;
        head = head.next;
        delNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return delNode.val;
    }

    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is emtpy.");
        }
        return head.val;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }


    public static void main(String[] args) {
        SingleListQueue<Integer> queue = new SingleListQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 2 == 0) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
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
