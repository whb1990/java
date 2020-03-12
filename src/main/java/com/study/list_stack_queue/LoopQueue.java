package main.java.com.study.list_stack_queue;

/**
 * @author: whb
 * @date: 2020/3/12 17:33
 * @description: 循环队列
 * 注意循环队列的内置数组中要浪费一个空间用来区分队列空和满；
 * 循环队列的出队操作比ArrayQueue要快很多，原因在于ArrayQueue出队要移动大量元素；
 */
public class LoopQueue<E> {
    private E[] data;

    private int front, tail;

    private int size;

    public LoopQueue(int capacity) {
        //因为要浪费一个空间，所以需要多开辟一个空间
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(5);
    }

    public int getCapacity() {
        //因为多开辟了一个空间，所以返回data.length - 1
        return data.length - 1;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(2 * getCapacity());
        }
        data[tail] = e;
        //尾部指针变化了
        tail = ((tail + 1) % data.length);
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return res;
    }

    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) { //实现方式二
            res.append(data[i]);
            if ((i + 1) % data.length != tail) res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 2 == 0) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
