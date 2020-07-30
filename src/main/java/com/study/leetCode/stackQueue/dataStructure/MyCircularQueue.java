package main.java.com.study.leetCode.stackQueue.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: whb
 * @date: 2020/5/28 17:22
 * @description: LeetCode-622-设计循环队列
 * 难度：中等
 * 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * <p>
 * 循环队列的一个好处是可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，就能使用这些空间去存储新的值。
 * <p>
 * 你的实现应该支持如下操作：
 * <p>
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 * <p>
 * 示例：
 * <p>
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 * <p>
 * circularQueue.enQueue(1);  // 返回 true
 * <p>
 * circularQueue.enQueue(2);  // 返回 true
 * <p>
 * circularQueue.enQueue(3);  // 返回 true
 * <p>
 * circularQueue.enQueue(4);  // 返回 false，队列已满
 * <p>
 * circularQueue.Rear();  // 返回 3
 * <p>
 * circularQueue.isFull();  // 返回 true
 * <p>
 * circularQueue.deQueue();  // 返回 true
 * <p>
 * circularQueue.enQueue(4);  // 返回 true
 * <p>
 * circularQueue.Rear();  // 返回 4
 */
public class MyCircularQueue {
    private int[] data;
    private int front, tail, size;

    public MyCircularQueue(int k) {
        this.data = new int[k];
        front = 0;
        tail = -1;
        size = 0;
    }

    /**
     * 入队
     *
     * @param value
     * @return
     */
    public boolean enqueue(int value) {
        if (isFull()) {
            return false;
        }
        tail = (tail + 1) % data.length;
        data[tail] = value;
        size++;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public boolean dequeue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % data.length;
        size--;
        return true;
    }

    /**
     * 获取队首元素
     *
     * @return
     */
    public int Front() {
        return isEmpty() ? -1 : data[front];
    }

    /**
     * 获取队尾元素
     *
     * @return
     */
    public int Rear() {
        return isEmpty() ? -1 : data[tail];
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return size == data.length;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enqueue(1));
        System.out.println(myCircularQueue.enqueue(2));
        System.out.println(myCircularQueue.enqueue(3));
        System.out.println(myCircularQueue.enqueue(4));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isFull());
        System.out.println(myCircularQueue.dequeue());
        System.out.println(myCircularQueue.enqueue(4));
        System.out.println(myCircularQueue.Rear());
        // 1. Initialize a queue.
        Queue<Integer> q = new LinkedList();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        // 4. Pop an element.
        System.out.println("Poll the first element is :" + q.poll());
        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size());
    }
}
