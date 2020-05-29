package main.java.com.study.leetCode.stackQueue.dataStructure;

/**
 * @author: whb
 * @date: 2020/3/12 17:07
 * @description: 使用Array动态数组和链表实现队列
 */
public class ArrayQueue<E> {

    private ArrayList<E> array;

    public ArrayQueue(int capacity) {
        this.array = new ArrayList<>(capacity);
    }

    public ArrayQueue() {
        this.array = new ArrayList<>();
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public void enqueue(E e) {
        array.addLast(e);
    }

    public E dequeue() {
        return array.removeFirst();
    }

    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        System.out.println(queue.toString());
        System.out.println(queue.dequeue());
        System.out.println(queue.toString());
        System.out.println(queue.getFront());
    }
}
